package com.rvkb.ecahier.facets

import woko.facets.builtin.all.LayoutAll
import net.sourceforge.jfacets.annotations.FacetKey

@FacetKey(name="layout", profileId="educ")
class EcahierLayout extends LayoutAll {

    @Override
    String getLayoutPath() {
        '/WEB-INF/jsp/layout.jsp'
    }


}
