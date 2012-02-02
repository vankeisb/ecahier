package com.rvkb.ecahier.facets.educ

import net.sourceforge.jfacets.annotations.FacetKey
import com.rvkb.ecahier.model.Entry
import woko.facets.builtin.developer.EditImpl
import net.sourceforge.jfacets.IInstanceFacet
import com.rvkb.ecahier.facets.FacetCategory

@FacetKey(name="edit", profileId="educ", targetObjectType=Entry.class)
@Mixin(FacetCategory)
class EditEntry extends EditImpl implements IInstanceFacet {

    boolean matchesTargetObject(Object targetObject) {
        checkTargetEntryIsOwnedByCurrentUser(targetObject)
    }


}
