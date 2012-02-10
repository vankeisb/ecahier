package com.rvkb.ecahier.facets.guest

import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.BaseFragmentFacet

@FacetKey(name="navBar",profileId="eguest")
class NavBarGuest extends BaseFragmentFacet {

  public String getPath() {
    return '/WEB-INF/jsp/guest/navBar.jsp'
  }
}
