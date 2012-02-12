package com.rvkb.ecahier.facets.educ

import com.rvkb.ecahier.model.User
import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.builtin.all.RenderPropertiesEditImpl

@FacetKey(name="renderPropertiesEdit", profileId="educ", targetObjectType=User.class)
class RenderUserPropertiesEdit extends RenderPropertiesEditImpl {

    @Override
    List<String> getPropertyNames() {
        if(facetContext.targetObject.id)
            return ["name", "email", "phoneNumber", "jobPosition", "avatarStripes"]
        else{
            // This case is an use creation, add username and role
            return ["username", "roles", "name", "email", "phoneNumber", "jobPosition", "avatarStripes"]
        }
    }
}
