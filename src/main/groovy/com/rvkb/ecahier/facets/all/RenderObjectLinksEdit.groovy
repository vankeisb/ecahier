package com.rvkb.ecahier.facets.all

import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.builtin.all.RenderLinksImpl
import woko.facets.builtin.all.RenderLinksEditImpl

@FacetKey(name="renderLinksEdit", profileId="educ")
class RenderObjectLinksEdit extends RenderLinksEditImpl {

    @Override
    String getPath() {
        '/WEB-INF/jsp/all/renderObjectLinksEdit.jsp'
    }


}
