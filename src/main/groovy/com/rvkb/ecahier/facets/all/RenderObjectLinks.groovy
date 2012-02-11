package com.rvkb.ecahier.facets.all

import woko.facets.builtin.all.RenderLinksImpl
import net.sourceforge.jfacets.annotations.FacetKey

@FacetKey(name="renderLinks", profileId="educ")
class RenderObjectLinks extends RenderLinksImpl {

    @Override
    String getPath() {
        '/WEB-INF/jsp/all/renderObjectLinks.jsp'
    }


}
