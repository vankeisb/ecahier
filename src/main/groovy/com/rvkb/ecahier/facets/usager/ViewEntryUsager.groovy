package com.rvkb.ecahier.facets.usager

import com.rvkb.ecahier.model.Entry
import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.builtin.developer.ViewImpl
import net.sourceforge.jfacets.IInstanceFacet
import com.rvkb.ecahier.facets.FacetCategory

@FacetKey(name="view", profileId="usager", targetObjectType=Entry.class)
@Mixin(FacetCategory)
class ViewEntryUsager extends ViewImpl implements IInstanceFacet{

    boolean matchesTargetObject(Object targetObject) {
        return targetObject.participants.contains(currentUser)
    }
}
