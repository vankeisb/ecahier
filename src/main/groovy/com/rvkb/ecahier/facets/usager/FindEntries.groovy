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
class FindEntries extends ListImpl {

    User user

    @Override
    protected ResultIterator<?> createResultIterator(ActionBeanContext abc, int start, int limit) {
        if ( (user) && (user.roles.contains("usager")) ){
            return store.getParticipatedEntriesForUser(user, start, limit)
        }
        // Should never happen.
        return new ListResultIterator<Object>(Collections.emptyList(), start, limit, 0);
    }
}
