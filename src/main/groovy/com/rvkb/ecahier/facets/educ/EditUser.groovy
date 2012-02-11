package com.rvkb.ecahier.facets.educ

import com.rvkb.ecahier.facets.FacetCategory
import com.rvkb.ecahier.model.Entry
import net.sourceforge.jfacets.IInstanceFacet
import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.builtin.developer.EditImpl
import com.rvkb.ecahier.model.User

@FacetKey(name="edit", profileId="educ", targetObjectType=User.class)
@Mixin(FacetCategory)
class EditUser extends EditImpl implements IInstanceFacet {

    boolean matchesTargetObject(Object targetObject) {
        if (currentUser.roles.contains("admin")){
            return true
        }
        return currentUser.equals(targetObject)
    }
}
