package com.rvkb.ecahier.facets.usager

import com.rvkb.ecahier.facets.FacetCategory
import com.rvkb.ecahier.model.Entry
import com.rvkb.ecahier.model.User
import net.sourceforge.jfacets.annotations.FacetKey
import net.sourceforge.stripes.action.ActionBeanContext
import woko.facets.builtin.developer.ListImpl
import woko.persistence.ResultIterator
import woko.persistence.ListResultIterator

@FacetKey(name="list", profileId="usager", targetObjectType=Entry.class)
@Mixin(FacetCategory)
class FindEntriesUsager extends ListImpl {

    User user

    @Override
    protected ResultIterator<?> createResultIterator(ActionBeanContext abc, int start, int limit) {
        // An 'usager' can see only the news where he participates
        return store.getParticipatedEntriesForUser(currentUser, start, limit)
    }
}
