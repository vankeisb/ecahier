package com.rvkb.ecahier.facets

import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.BaseResolutionFacet
import net.sourceforge.stripes.action.Resolution
import net.sourceforge.stripes.action.ActionBeanContext
import com.rvkb.ecahier.model.Entry
import net.sourceforge.stripes.action.RedirectResolution
import com.rvkb.ecahier.woko.EcahierUserManager

@FacetKey(name="populate", profileId="all")
class Populate extends BaseResolutionFacet {

    Resolution getResolution(ActionBeanContext actionBeanContext) {
        EcahierUserManager um = facetContext.woko.userManager
        def kakou = um.getUserByUsername("kakou")
        def sofiane = um.getUserByUsername("sofiane")
        def david = um.getUserByUsername("david")
        def range = 1..100
        Entry e0 = new Entry([text:"this is the text of the entry in <b>HTML</b>this is the text of the entry in <b>HTML</b>this is the text of the entry in <b>HTML</b>this is the text of the entry in <b>HTML</b>this is the text of the entry in <b>HTML</b>this is the text of the entry in <b>HTML</b>this is the text of the entry in <b>HTML</b>this is the text of the entry in <b>HTML</b>this is the text of the entry in <b>HTML</b>this is the text of the entry in <b>HTML</b>this is the text of the entry in <b>HTML</b>",
          createdBy:david])
        objectStore.save(e0)

        range.each {
            if (it % 2 == 0) {
                Entry e = new Entry([text:"$it this is the text of the entry in <b>HTML</b>",
                  createdBy:kakou])
                e.addToParticipants(sofiane)
                e.addToParticipants(david)
                objectStore.save(e)
            } else {
                Entry e = new Entry([text:"$it this is the text of the entry in <b>HTML</b>",
                  createdBy:david])
                e.addToParticipants(kakou)
                e.addToParticipants(sofiane)
                objectStore.save(e)
            }
        }
        return new RedirectResolution("/view/Entry/$e.id")
    }


}
