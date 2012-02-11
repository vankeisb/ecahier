package com.rvkb.ecahier.facets.all

import woko.facets.builtin.all.RenderTitleImpl
import net.sourceforge.jfacets.annotations.FacetKey
import net.sourceforge.jfacets.annotations.FacetKeyList
import com.rvkb.ecahier.model.Entry
import java.text.DateFormat
import com.rvkb.ecahier.facets.FacetCategory

@FacetKeyList(
    keys=[
    @FacetKey(name="renderTitle", profileId="eguest", targetObjectType=Entry.class),
    @FacetKey(name="renderTitle", profileId="educ", targetObjectType=Entry.class)
    ]
)
@Mixin(FacetCategory)
class RenderTitleEntry extends RenderTitleImpl {

    @Override
    String getPath() {
        return '/WEB-INF/jsp/all/renderTitle.jsp'
    }

    @Override
    String getTitle() {
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT);
        Entry e = facetContext.targetObject
        def formattedDate = df.format(e.creationDate)
        return "$formattedDate - ${currentUser.username}"
    }


}

