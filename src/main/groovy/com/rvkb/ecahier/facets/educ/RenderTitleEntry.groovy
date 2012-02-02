package com.rvkb.ecahier.facets.educ

import net.sourceforge.jfacets.annotations.FacetKey
import com.rvkb.ecahier.model.Entry
import woko.facets.builtin.all.RenderTitleImpl
import java.text.DateFormat
import com.rvkb.ecahier.facets.FacetCategory

@FacetKey(name="renderTitle", profileId="educ", targetObjectType=Entry.class)
@Mixin(FacetCategory)
class RenderTitleEntry extends RenderTitleImpl {

    @Override
    String getTitle() {
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT);
        Entry e = facetContext.targetObject
        def formattedDate = df.format(e.creationDate)
        return "$formattedDate - ${currentUser.username}"
    }


}
