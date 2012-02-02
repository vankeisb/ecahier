package com.rvkb.ecahier.facets.educ

import woko.facets.builtin.all.RenderPropertiesEditImpl
import com.rvkb.ecahier.model.Entry
import net.sourceforge.jfacets.annotations.FacetKey

@FacetKey(name="renderPropertiesEdit", profileId="educ", targetObjectType=Entry.class)
class RenderEntryPropertiesEdit extends RenderPropertiesEditImpl {

    @Override
    List<String> getPropertyNames() {
        ["participants", "text"]
    }

}
