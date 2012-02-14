package com.rvkb.ecahier.facets.users

import net.sourceforge.jfacets.annotations.FacetKey
import com.rvkb.ecahier.model.Entry
import woko.facets.builtin.all.RenderPropertiesImpl
import net.sourceforge.jfacets.annotations.FacetKeyList

@FacetKeyList(
    keys=[
    @FacetKey(name="renderProperties", profileId="educ", targetObjectType=Entry.class),
    @FacetKey(name="renderProperties", profileId="usager", targetObjectType=Entry.class)
    ]
)
class RenderEntryProperties extends RenderPropertiesImpl {

    @Override
    List<String> getPropertyNames() {
        ["participants", "text"]
    }

}
