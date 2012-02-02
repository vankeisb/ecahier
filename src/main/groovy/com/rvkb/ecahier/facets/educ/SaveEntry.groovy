package com.rvkb.ecahier.facets.educ

import net.sourceforge.jfacets.annotations.FacetKey
import com.rvkb.ecahier.model.Entry
import woko.facets.builtin.developer.SaveImpl
import net.sourceforge.stripes.action.ActionBeanContext
import com.rvkb.ecahier.facets.FacetCategory
import net.sourceforge.jfacets.IInstanceFacet

@FacetKey(name="save",profileId="educ",targetObjectType=Entry.class)
@Mixin(FacetCategory)
class SaveEntry extends SaveImpl implements IInstanceFacet {

    @Override
    protected void doSave(ActionBeanContext abc) {
        Entry e = facetContext.targetObject
        if (e.createdBy==null) {
            e.createdBy = currentUser
        }
        super.doSave(abc)
    }

    boolean matchesTargetObject(Object targetObject) {
        checkTargetEntryIsOwnedByCurrentUser(targetObject)
    }

}
