package com.rvkb.ecahier.facets.educ

import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.builtin.developer.SearchImpl

@FacetKey(name="search", profileId="educ")
class Search extends SearchImpl {

    @Override
    String getPath() {
        '/WEB-INF/jsp/educ/search.jsp'
    }


}
