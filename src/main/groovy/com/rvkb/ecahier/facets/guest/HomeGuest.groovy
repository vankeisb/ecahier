package com.rvkb.ecahier.facets.guest

import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.builtin.all.HomeImpl
import net.sourceforge.stripes.action.Resolution
import net.sourceforge.stripes.action.ActionBeanContext
import net.sourceforge.stripes.action.RedirectResolution

@FacetKey(name="home", profileId="eguest")
class HomeGuest extends HomeImpl {

    @Override
    Resolution getResolution(ActionBeanContext abc) {
        return new RedirectResolution('/login')
    }


}