package com.rvkb.ecahier.facets.educ

import com.rvkb.ecahier.facets.FacetCategory
import com.rvkb.ecahier.model.Entry
import net.sourceforge.jfacets.IInstanceFacet
import net.sourceforge.jfacets.annotations.FacetKey
import net.sourceforge.stripes.action.ActionBeanContext
import woko.facets.builtin.developer.SaveImpl
import com.rvkb.ecahier.model.User
import org.hibernate.Hibernate
import com.rvkb.ecahier.utils.ImageUtils

@FacetKey(name="save",profileId="educ",targetObjectType=User.class)
@Mixin(FacetCategory)
class SaveUser extends SaveImpl implements IInstanceFacet {

    @Override
    protected void doSave(ActionBeanContext abc) {
        // Decode avatar and create User avatar
        User user = facetContext.targetObject
        if (user.avatarStripes) {
            ByteArrayOutputStream bos = new ByteArrayOutputStream()
            ImageUtils.rescaleImage(user.avatarStripes.inputStream, 150, bos)
            user.avatar = Hibernate.createBlob(new ByteArrayInputStream(bos.toByteArray()))
        }

        // During user creation (by admin) we need to generate a password
        if (!user.id){
            String pwd = user.username + "!"
            user.setPassword(Integer.toString(pwd.hashCode()))
        }

        super.doSave(abc)
    }

    boolean matchesTargetObject(Object targetObject) {
        if (currentUser.roles.contains("admin")){
            return true
        }
        return currentUser.equals(targetObject)
    }

}
