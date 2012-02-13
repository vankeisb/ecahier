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

    @Override
    protected ResultIterator<?> createResultIterator(ActionBeanContext abc, int start, int limit) {
        // Get key from request parameter
        String key = facetContext.request.getParameter("key")
        if(key){
            // We are looking for entries with user correspondence
            User u = (User)store.load("User", key)
            // If User is an Educ -> Display only its authored news
            if (u.roles.contains('educ'))
                return store.getAuthoredEntriesForUser(u, start, limit)
            // Else, user is an Usager -> Display news where he participates
            else
                return store.getParticipatedEntriesForUser(u, start, limit)
        }
        return super.createResultIterator(abc, start, limit)
    }


}
