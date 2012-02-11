package com.rvkb.ecahier.facets.all

import com.rvkb.ecahier.model.Entry
import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.builtin.all.RenderPropertyValueImpl

@FacetKey(name="renderPropertyValue_createdBy", profileId="all", targetObjectType=Entry.class)
class RenderPropertyEntryCreatedBy extends RenderPropertyValueImpl {

    @Override
    String getPath() {
        '/WEB-INF/jsp/all/renderPropertyEntryCreatedBy.jsp'
    }


}
