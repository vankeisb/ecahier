package com.rvkb.ecahier.facets.usager

import com.rvkb.ecahier.facets.FacetCategory
import com.rvkb.ecahier.model.User
import net.sourceforge.jfacets.IInstanceFacet
import net.sourceforge.jfacets.annotations.FacetKey
import net.sourceforge.stripes.action.ActionBeanContext
import org.hibernate.Hibernate
import woko.facets.builtin.developer.SaveImpl

@FacetKey(name="save",profileId="usager",targetObjectType=User.class)
@Mixin(FacetCategory)
class SaveUserUsager extends SaveImpl implements IInstanceFacet {

    @Override
    protected void doSave(ActionBeanContext abc) {
        // Decode avatar and create User avatar
        User user = facetContext.targetObject
        if (user.avatarStripes)
            user.avatar = Hibernate.createBlob(user.avatarStripes.inputStream)

        super.doSave(abc)
    }

    boolean matchesTargetObject(Object targetObject) {
        return currentUser.equals(targetObject)
    }

}
