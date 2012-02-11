package com.rvkb.ecahier.facets.educ

import com.rvkb.ecahier.model.Entry
import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.builtin.all.RenderPropertiesImpl
import com.rvkb.ecahier.model.User

@FacetKey(name="renderProperties", profileId="educ", targetObjectType=User.class)
class RenderUserProperties extends RenderPropertiesImpl {

    @Override
    String getPath() {
        return '/WEB-INF/jsp/educ/renderUserProperties.jsp'
    }
}
