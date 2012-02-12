package com.rvkb.ecahier.facets.all

import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.BaseResolutionFacet
import net.sourceforge.stripes.action.Resolution
import net.sourceforge.stripes.action.ActionBeanContext
import net.sourceforge.stripes.action.ForwardResolution

@FacetKey(name="about", profileId="all")
class About extends BaseResolutionFacet{

    Resolution getResolution(ActionBeanContext actionBeanContext) {
        return new ForwardResolution('/WEB-INF/jsp/all/about.jsp')
    }


}
