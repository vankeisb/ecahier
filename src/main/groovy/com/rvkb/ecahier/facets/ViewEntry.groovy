package com.rvkb.ecahier.facets

import net.sourceforge.jfacets.annotations.FacetKey
import com.rvkb.ecahier.model.Entry
import woko.facets.builtin.developer.ViewImpl

@FacetKey(name="view", profileId="educ", targetObjectType=Entry.class)
class ViewEntry extends ViewImpl {
}
