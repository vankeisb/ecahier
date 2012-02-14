package com.rvkb.ecahier.facets.all

import net.sourceforge.jfacets.annotations.FacetKey
import net.sourceforge.jfacets.annotations.FacetKeyList
import woko.facets.builtin.all.RenderObjectImpl


@FacetKeyList(
    keys=[
    @FacetKey(name="renderObject", profileId="eguest"),
    @FacetKey(name="renderObject", profileId="educ"),
    @FacetKey(name="renderObject", profileId="usager"),
    ]
)
class RenderObject extends RenderObjectImpl{

    @Override
    String getPath() {
        return '/WEB-INF/jsp/all/renderObject.jsp'
    }


}
