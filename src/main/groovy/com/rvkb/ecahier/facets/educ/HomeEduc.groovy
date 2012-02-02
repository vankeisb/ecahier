package com.rvkb.ecahier.facets.educ

import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.builtin.all.HomeImpl

@FacetKey(name="home", profileId="educ")
class HomeEduc extends HomeImpl {

    @Override
    String getPath() {
        'WEB-INF/jsp/educ/home.jsp'
    }


}
