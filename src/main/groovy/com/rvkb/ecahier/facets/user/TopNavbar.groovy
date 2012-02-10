package com.rvkb.ecahier.facets.user

import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.BaseFragmentFacet
import net.sourceforge.jfacets.annotations.FacetKeyList
import com.rvkb.ecahier.facets.FacetCategory

@FacetKeyList(keys = [
    @FacetKey(name="topNavBar",profileId="educ"),
    @FacetKey(name="topNavBar", profileId="usager"),
])
@Mixin(FacetCategory)
class TopNavbar extends BaseFragmentFacet {

    Long getCurrentUserId() {
        if (currentUser){
            def id = currentUser?.id
            return id!=null ? id : 0
        }
        return null
    }
    public String getPath() {
        return '/WEB-INF/jsp/user/topNavBar.jsp'
    }
}
