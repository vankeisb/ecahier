package com.rvkb.ecahier.facets.all

import net.sourceforge.jfacets.annotations.FacetKey
import net.sourceforge.jfacets.annotations.FacetKeyList
import woko.facets.builtin.all.RenderObjectImpl
import woko.facets.builtin.all.RenderObjectEditImpl

@FacetKey(name="renderObjectEdit", profileId="all")
class RenderObjectEdit extends RenderObjectEditImpl{

    @Override
    String getPath() {
        return '/WEB-INF/jsp/all/renderObjectEdit.jsp'
    }


}
