package com.rvkb.ecahier.facets.admin

import net.sourceforge.jfacets.annotations.FacetKey
import com.rvkb.ecahier.model.User
import com.rvkb.ecahier.facets.FacetCategory
import woko.facets.builtin.developer.SaveImpl
import net.sourceforge.stripes.action.ActionBeanContext
import com.rvkb.ecahier.utils.ImageUtils
import org.hibernate.Hibernate
import net.sourceforge.stripes.action.Resolution
import net.sourceforge.stripes.action.RedirectResolution
import net.sourceforge.stripes.action.LocalizableMessage

@FacetKey(name="save",profileId="admin",targetObjectType=User.class)
@Mixin(FacetCategory)
class SaveUserAdmin extends SaveImpl {

    @Override
    protected void doSave(ActionBeanContext abc) {
        User user = facetContext.targetObject
        // During user creation we need to generate a password
        if (!user.id){
            String pwd = user.username + "!"
            user.setPassword(Integer.toString(pwd.hashCode()))
        }

        store.saveUser(user)
    }

    @Override
    protected Resolution getNonRpcResolution(ActionBeanContext abc) {
        // Admin edit its own profile
        if (currentUser.equals(facetContext.targetObject)){
            abc.getMessages().add(new LocalizableMessage("users.save.my.profil"));
            return new RedirectResolution(woko.facetUrl("view",facetContext.targetObject));
        }else{
            abc.getMessages().add(new LocalizableMessage("admin.save.other.profil"));
            return new RedirectResolution('/admin')
        }
    }
}
