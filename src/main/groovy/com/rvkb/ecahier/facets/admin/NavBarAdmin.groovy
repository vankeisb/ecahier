package com.rvkb.ecahier.facets.admin

import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.builtin.all.NavBarAll

@FacetKey(name="navBar", profileId="admin")
class NavBarAdmin extends NavBarAll {

    @Override
    String getPath() {
        '/WEB-INF/jsp/admin/navBar.jsp'
    }

    boolean isAdmin() {
        true
    }


}
