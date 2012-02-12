package com.rvkb.ecahier.facets.educ

import woko.facets.builtin.all.NavBarAll
import net.sourceforge.jfacets.annotations.FacetKey
import com.rvkb.ecahier.facets.FacetCategory

@FacetKey(name="navBar", profileId="educ")
@Mixin(FacetCategory)
class NavBarEduc extends NavBarAll {

    @Override
    String getPath() {
        '/WEB-INF/jsp/educ/navBar.jsp'
    }

    boolean isAdmin() {
        currentUser?.roles?.contains("admin")
    }


}
