package com.rvkb.ecahier.facets.all

import com.rvkb.ecahier.facets.FacetCategory
import com.rvkb.ecahier.model.Entry
import java.text.DateFormat
import net.sourceforge.jfacets.annotations.FacetKey
import net.sourceforge.jfacets.annotations.FacetKeyList
import woko.facets.builtin.all.RenderTitleImpl
import com.rvkb.ecahier.model.User

@FacetKeyList(
    keys=[
    @FacetKey(name="renderTitle", profileId="eguest", targetObjectType=User.class),
    @FacetKey(name="renderTitle", profileId="educ", targetObjectType=User.class)
    ]
)
@Mixin(FacetCategory)
class RenderTitleUser extends RenderTitleImpl {

    @Override
    String getPath() {
        return '/WEB-INF/jsp/all/renderTitle.jsp'
    }

    @Override
    String getTitle() {
        User u = facetContext.targetObject
        StringBuilder sb = new StringBuilder(u.username)
        if(u.name)
            sb.append(" ($u.name)")

        return sb.toString()
    }
}

