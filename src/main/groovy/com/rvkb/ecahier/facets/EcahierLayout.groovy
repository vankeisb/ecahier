package com.rvkb.ecahier.facets

import woko.facets.builtin.all.LayoutAll
import net.sourceforge.jfacets.annotations.FacetKey

@FacetKey(name="layout", profileId="educ")
@Mixin(FacetCategory)
class EcahierLayout extends LayoutAll {

    @Override
    String getLayoutPath() {
        '/WEB-INF/jsp/layout.jsp'
    }

    Long getCurrentUserId() {
        def id = currentUser?.id
        return id!=null ? id : 0
    }

    @Override
    List<String> getCssIncludes() {
        return []
    }

    @Override
    String getAppTitle() {
        'ecahier'
    }


}
