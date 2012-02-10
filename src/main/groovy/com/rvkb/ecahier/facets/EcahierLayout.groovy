package com.rvkb.ecahier.facets

import woko.facets.builtin.all.LayoutAll
import net.sourceforge.jfacets.annotations.FacetKey
import net.sourceforge.jfacets.annotations.FacetKeyList

@FacetKeyList(keys = [
    @FacetKey(name="layout", profileId="educ"),
    @FacetKey(name="layout", profileId="usager"),
    @FacetKey(name="layout", profileId="eguest"),
])
@Mixin(FacetCategory)
class EcahierLayout extends LayoutAll {

    @Override
    String getLayoutPath() {
        '/WEB-INF/jsp/layout.jsp'
    }

    Long getCurrentUserId() {
        if (currentUser){
            def id = currentUser?.id
            return id!=null ? id : 0
        }
        return null
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
