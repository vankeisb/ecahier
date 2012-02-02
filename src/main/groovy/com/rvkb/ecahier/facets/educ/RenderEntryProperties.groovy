package com.rvkb.ecahier.facets.educ

import net.sourceforge.jfacets.annotations.FacetKey
import com.rvkb.ecahier.model.Entry
import woko.facets.builtin.all.RenderPropertiesImpl

@FacetKey(name="renderProperties", profileId="educ", targetObjectType=Entry.class)
class RenderEntryProperties extends RenderPropertiesImpl {

    @Override
    List<String> getPropertyNames() {
        ["createdBy", "participants", "text"]
    }

}
