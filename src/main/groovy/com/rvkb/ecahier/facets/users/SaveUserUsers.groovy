package com.rvkb.ecahier.facets.users

import woko.facets.builtin.developer.SaveImpl
import net.sourceforge.jfacets.IInstanceFacet
import net.sourceforge.jfacets.annotations.FacetKey
import com.rvkb.ecahier.model.User
import com.rvkb.ecahier.facets.FacetCategory
import net.sourceforge.stripes.action.ActionBeanContext
import com.rvkb.ecahier.utils.ImageUtils
import org.hibernate.Hibernate
import net.sourceforge.jfacets.annotations.FacetKeyList
import net.sourceforge.stripes.action.Resolution
import net.sourceforge.stripes.action.RedirectResolution
import net.sourceforge.stripes.action.LocalizableMessage

@FacetKeyList(
    keys=[
        @FacetKey(name="save",profileId="educ",targetObjectType=User.class),
        @FacetKey(name="save",profileId="usager",targetObjectType=User.class)
    ]
)
@Mixin(FacetCategory)
class SaveUserUsers extends SaveImpl implements IInstanceFacet{

    @Override
    protected void doSave(ActionBeanContext abc) {
        User user = facetContext.targetObject
        store.saveUser(user)
    }

    @Override
    boolean matchesTargetObject(Object targetObject) {
        return currentUser.equals(targetObject)
    }

    @Override
    protected Resolution getNonRpcResolution(ActionBeanContext abc) {
        abc.getMessages().add(new LocalizableMessage("users.save.my.profil"));
        return new RedirectResolution(woko.facetUrl("view",facetContext.targetObject));
    }

}
