package com.rvkb.ecahier.facets.admin

import net.sourceforge.jfacets.annotations.FacetKey
import com.rvkb.ecahier.model.User
import net.sourceforge.jfacets.IInstanceFacet
import com.rvkb.ecahier.facets.FacetCategory
import woko.facets.builtin.developer.DeleteImpl

@FacetKey(name="delete", profileId="admin", targetObjectType=User.class)
@Mixin(FacetCategory)
class DeleteUser extends DeleteImpl implements IInstanceFacet{

    boolean matchesTargetObject(Object targetObject) {
        return !currentUser.equals(targetObject)
    }
}
