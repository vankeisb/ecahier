package com.rvkb.ecahier.facets.usager

import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.builtin.all.HomeImpl

@FacetKey(name="home", profileId="usager")
class HomeUsager extends HomeImpl {

    @Override
    String getPath() {
        'WEB-INF/jsp/usager/home.jsp'
    }


}
