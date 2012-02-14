package com.rvkb.ecahier.facets.all

import net.sourceforge.jfacets.annotations.FacetKey
import net.sourceforge.jfacets.annotations.FacetKeyList
import woko.facets.builtin.all.RenderObjectImpl


@FacetKey(name="renderObject", profileId="all")
class RenderObject extends RenderObjectImpl{

    @Override
    String getPath() {
        return '/WEB-INF/jsp/all/renderObject.jsp'
    }


}
