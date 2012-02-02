package com.rvkb.ecahier.facets.educ

import net.sourceforge.jfacets.annotations.FacetKey
import com.rvkb.ecahier.model.Entry
import woko.facets.builtin.all.RenderPropertyValueImpl

@FacetKey(name="renderPropertyValue_text", profileId="all", targetObjectType=Entry.class)
class RenderPropertyEntryText extends RenderPropertyValueImpl {

    @Override
    String getPath() {
        '/WEB-INF/jsp/all/renderPropertyEntryText.jsp'
    }

}
