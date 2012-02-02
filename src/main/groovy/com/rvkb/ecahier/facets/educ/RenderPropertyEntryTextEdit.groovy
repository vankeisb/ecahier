package com.rvkb.ecahier.facets.educ

import net.sourceforge.jfacets.annotations.FacetKey
import com.rvkb.ecahier.model.Entry
import woko.facets.builtin.all.RenderPropertyValueEditStripesText

@FacetKey(name="renderPropertyValueEdit_text", profileId="educ", targetObjectType=Entry.class)
class RenderPropertyEntryTextEdit extends RenderPropertyValueEditStripesText {

    @Override
    String getPath() {
        '/WEB-INF/jsp/educ/renderPropertyEditEntryText.jsp'
    }


}
