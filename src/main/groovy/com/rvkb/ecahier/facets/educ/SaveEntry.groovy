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

    String participantsStr

    @Override
    protected void doSave(ActionBeanContext abc) {
        Entry e = facetContext.targetObject
        if (e.createdBy==null) {
            e.createdBy = currentUser
        }

        // decode participants string
        def um = facetContext.woko.userManager
        e.participants = []
        if (participantsStr) {
            participantsStr.split(",").each { username ->
                def u = um.getUserByUsername(username.trim());
                if (u) {
                    if (!e.participants.contains(u)) {
                        e.participants << u
                    }
                }
            }
        }

        super.doSave(abc)
    }

    boolean matchesTargetObject(Object targetObject) {
        checkTargetEntryIsOwnedByCurrentUser(targetObject)
    }

}
