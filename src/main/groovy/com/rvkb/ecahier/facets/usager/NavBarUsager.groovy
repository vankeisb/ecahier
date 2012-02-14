package com.rvkb.ecahier.facets.usager

import com.rvkb.ecahier.facets.FacetCategory
import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.builtin.all.NavBarAll

@FacetKey(name="navBar", profileId="usager")
@Mixin(FacetCategory)
class NavBarUsager extends NavBarAll {

    @Override
    String getPath() {
        '/WEB-INF/jsp/usager/navBar.jsp'
    }
}
