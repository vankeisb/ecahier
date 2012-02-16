package com.rvkb.ecahier.facets.admin

import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.BaseResolutionFacet
import net.sourceforge.stripes.action.Resolution
import net.sourceforge.stripes.action.ActionBeanContext
import net.sourceforge.stripes.action.ForwardResolution
import woko.persistence.ResultIterator
import com.rvkb.ecahier.model.User
import com.rvkb.ecahier.facets.FacetCategory

@FacetKey(name="admin", profileId="admin")
@Mixin(FacetCategory)
class Admin extends BaseResolutionFacet {

    Resolution getResolution(ActionBeanContext actionBeanContext) {
        return new ForwardResolution('/WEB-INF/jsp/admin/admin.jsp')
    }

    ResultIterator<User> getUsers() {
        Integer start = (page-1) * resultsPerPage;
        ResultIterator<User> results;
        results = store.getUsersForAdministration(currentUser, start, resultsPerPage)

        return results
    }

    Integer getResultsPerPage() {
        return 50
    }

    Integer getPage() {
        String page = facetContext.getRequest().getParameter('facet.page')
        if (!page)
            page=1
        return Integer.valueOf(page)
    }


}
