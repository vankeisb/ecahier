package com.rvkb.ecahier.facets.usager

import com.rvkb.ecahier.facets.FacetCategory
import com.rvkb.ecahier.model.User
import net.sourceforge.jfacets.IInstanceFacet
import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.builtin.developer.EditImpl

@FacetKey(name="edit", profileId="usager", targetObjectType=User.class)
@Mixin(FacetCategory)
class EditUserUsager extends EditImpl implements IInstanceFacet {

    boolean matchesTargetObject(Object targetObject) {
        return currentUser.equals(targetObject)
    }
}
