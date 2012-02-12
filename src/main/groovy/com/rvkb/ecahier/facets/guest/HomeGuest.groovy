package com.rvkb.ecahier.facets.guest

import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.builtin.all.HomeImpl

@FacetKey(name="home", profileId="eguest")
class HomeGuest extends HomeImpl {

    @Override
    String getPath() {
        'WEB-INF/woko/jsp/login.jsp'
    }


}