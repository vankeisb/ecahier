package com.rvkb.ecahier.facets.educ

import woko.facets.builtin.all.NavBarAll
import net.sourceforge.jfacets.annotations.FacetKey

@FacetKey(name="navBar", profileId="educ")
class NavBarEduc extends NavBarAll {

    @Override
    String getPath() {
        '/WEB-INF/jsp/educ/navBar.jsp'
    }


}
