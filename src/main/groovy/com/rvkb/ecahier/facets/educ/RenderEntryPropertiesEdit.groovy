package com.rvkb.ecahier.facets.educ

import woko.facets.builtin.all.RenderPropertiesEditImpl
import com.rvkb.ecahier.model.Entry
import net.sourceforge.jfacets.annotations.FacetKey

@FacetKey(name="renderPropertiesEdit", profileId="educ", targetObjectType=Entry.class)
class RenderEntryPropertiesEdit extends RenderPropertiesEditImpl {

    RenderEntryPropertiesEdit() {
        useFlatLayout = true
    }

    @Override
    List<String> getPropertyNames() {
        ["text", "participants"]
    }

}
