package com.rvkb.ecahier.facets.educ

import woko.facets.builtin.developer.ListImpl
import net.sourceforge.jfacets.annotations.FacetKey
import com.rvkb.ecahier.model.Entry

@FacetKey(name="list", profileId="educ", targetObjectType=Entry.class)
class FindEntries extends ListImpl {
}
