package com.rvkb.ecahier.facets.all

import net.sourceforge.jfacets.annotations.FacetKey
import com.rvkb.ecahier.model.Entry
import woko.facets.builtin.all.RenderPropertyValueImpl

@FacetKey(name="renderPropertyValue_participants", profileId="all", targetObjectType=Entry.class)
class RenderPropertyEntryParticipants extends RenderPropertyValueImpl {

    @Override
    String getPath() {
        '/WEB-INF/jsp/all/renderPropertyEntryParticipants.jsp'
    }


}
