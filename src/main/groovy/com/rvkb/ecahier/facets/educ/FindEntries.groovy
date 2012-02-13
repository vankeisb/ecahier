package com.rvkb.ecahier.facets.educ

import woko.facets.builtin.developer.ListImpl
import net.sourceforge.jfacets.annotations.FacetKey
import com.rvkb.ecahier.model.Entry
import woko.persistence.ResultIterator
import net.sourceforge.stripes.action.ActionBeanContext
import com.rvkb.ecahier.facets.FacetCategory
import com.rvkb.ecahier.model.User

@FacetKey(name="list", profileId="educ", targetObjectType=Entry.class)
@Mixin(FacetCategory)
class FindEntries extends ListImpl {

    User user

    @Override
    protected ResultIterator<?> createResultIterator(ActionBeanContext abc, int start, int limit) {
        if (!user) {
            // user not bound, default behavior
            return super.createResultIterator(abc, start, limit)
        }
        user?.roles?.contains("educ") ?
            store.getAuthoredEntriesForUser(user, start, limit) :
            store.getParticipatedEntriesForUser(user, start, limit)
    }


}
