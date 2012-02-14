package com.rvkb.ecahier.facets.all

import woko.facets.builtin.all.RenderTitleImpl
import net.sourceforge.jfacets.annotations.FacetKey
import net.sourceforge.jfacets.annotations.FacetKeyList
import com.rvkb.ecahier.model.Entry
import java.text.DateFormat
import com.rvkb.ecahier.facets.FacetCategory

@FacetKey(name="renderTitle", profileId="all", targetObjectType=Entry.class)
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
        // Title for entry creation
        if (!e.id)
            return "$formattedDate - ${currentUser.username}"
        // Title for Entry already created
        else
            return "$formattedDate - ${e?.createdBy?.username}"
    }


}

