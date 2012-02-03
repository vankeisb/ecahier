package com.rvkb.ecahier.facets.educ

import net.sourceforge.jfacets.annotations.FacetKey
import net.sourceforge.stripes.action.ActionBeanContext
import woko.persistence.ResultIterator
import woko.facets.builtin.BaseResultFacet

@FacetKey(name="usercompletion", profileId="educ")
class UserCompletion extends BaseResultFacet {

    String criteria

    @Override
    protected ResultIterator createResultIterator(ActionBeanContext actionBeanContext, int start, int limit) {
            objectStore.getCompletionUsers(criteria, start, limit)
    }

    @Override
    String getPath() {
        // TODO if we need to use this (not sure we do)
        '/WEB-INF/jsp/all/usercompletion.jsp'
    }

}
