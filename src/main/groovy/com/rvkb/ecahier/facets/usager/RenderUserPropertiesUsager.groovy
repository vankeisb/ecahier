package com.rvkb.ecahier.facets.usager

import com.rvkb.ecahier.model.User
import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.builtin.all.RenderPropertiesImpl
import com.rvkb.ecahier.facets.FacetCategory

@FacetKey(name="renderProperties", profileId="usager", targetObjectType=User.class)
@Mixin(FacetCategory)
class RenderUserPropertiesUsager extends RenderPropertiesImpl {

    @Override
    String getPath() {
        if (facetContext.targetObject.equals(currentUser))
            return '/WEB-INF/jsp/usager/renderMyProperties.jsp'
        else
            return '/WEB-INF/jsp/usager/renderUserProperties.jsp'
    }
    
}
