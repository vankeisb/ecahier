package com.rvkb.ecahier.facets

import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.BaseResolutionFacet
import net.sourceforge.stripes.action.Resolution
import net.sourceforge.stripes.action.ActionBeanContext
import com.rvkb.ecahier.model.Entry
import net.sourceforge.stripes.action.RedirectResolution
import com.rvkb.ecahier.model.User

@FacetKey(name="populate", profileId="all")
class Populate extends BaseResolutionFacet {

    Resolution getResolution(ActionBeanContext actionBeanContext) {
        User kakou = facetContext.woko.userManager.getUserByUsername("kakou")
        Entry e = new Entry([text:"this is the text of the entry in <b>HTML</b>",
          createdBy:kakou])
        objectStore.save(e)

        return new RedirectResolution("/view/Entry/$e.id")
    }


}
