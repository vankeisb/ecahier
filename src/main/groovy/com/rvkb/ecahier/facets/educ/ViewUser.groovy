package com.rvkb.ecahier.facets.educ

import net.sourceforge.jfacets.annotations.FacetKey
import com.rvkb.ecahier.model.User
import woko.facets.builtin.developer.ViewImpl

@FacetKey(name="view", profileId="educ", targetObjectType=User.class)
class ViewUser extends ViewImpl {

    @Override
    String getPath() {
        return '/WEB-INF/jsp/educ/viewUser.jsp'
    }


}
