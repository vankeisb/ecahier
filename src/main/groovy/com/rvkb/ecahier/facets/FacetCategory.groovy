package com.rvkb.ecahier.facets

import woko.facets.BaseFacet
import com.rvkb.ecahier.model.User

@Category(BaseFacet)
class FacetCategory {

    User getCurrentUser() {
        def uname = woko.getUsername(facetContext.request)
        if (uname==null) {
            return null
        } else {
            return woko.userManager.getUserByUsername(uname)
        }
    }

    def checkTargetEntryIsOwnedByCurrentUser(entry) {
        def uname = woko.getUsername(facetContext.request)
        def entityOwner = entry?.createdBy?.username
        if (entityOwner) {
            return uname == entityOwner
        }
        return true // bet is probably transient
    }

}
