package com.rvkb.ecahier.facets.guest

import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.BaseFragmentFacet

@FacetKey(name="topNavBar",profileId="eguest")
class TopNavbar extends BaseFragmentFacet {

  public String getPath() {
    return '/WEB-INF/jsp/guest/topNavbar.jsp'
  }
}
