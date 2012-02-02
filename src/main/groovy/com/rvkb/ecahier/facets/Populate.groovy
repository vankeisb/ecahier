package com.rvkb.ecahier.facets

import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.BaseResolutionFacet
import net.sourceforge.stripes.action.Resolution
import net.sourceforge.stripes.action.ActionBeanContext
import com.rvkb.ecahier.model.Entry
import net.sourceforge.stripes.action.RedirectResolution
import com.rvkb.ecahier.model.User
import com.rvkb.ecahier.woko.EcahierUserManager

@FacetKey(name="populate", profileId="all")
class Populate extends BaseResolutionFacet {

    Resolution getResolution(ActionBeanContext actionBeanContext) {
        EcahierUserManager um = facetContext.woko.userManager
        User kakou = um.getUserByUsername("kakou")
        User sofiane = um.getUserByUsername("sofiane")
        Entry e = new Entry([text:"this is the text of the entry in <b>HTML</b>",
          createdBy:kakou])
        e.addToParticipants(sofiane)
        objectStore.save(e)
        return new RedirectResolution("/view/Entry/$e.id")
    }


}
