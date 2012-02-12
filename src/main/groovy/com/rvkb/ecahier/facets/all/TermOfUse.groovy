package com.rvkb.ecahier.facets.all

import net.sourceforge.jfacets.annotations.FacetKey
import net.sourceforge.stripes.action.ActionBeanContext
import net.sourceforge.stripes.action.ForwardResolution
import net.sourceforge.stripes.action.Resolution
import woko.facets.BaseResolutionFacet

@FacetKey(name="termOfUse", profileId="all")
class TermOfUse extends BaseResolutionFacet{

    Resolution getResolution(ActionBeanContext actionBeanContext) {
        return new ForwardResolution('/WEB-INF/jsp/all/termOfUse.jsp')
    }


}
