package com.rvkb.ecahier.facets.educ

import com.rvkb.ecahier.model.User
import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.builtin.all.RenderPropertiesEditImpl

@FacetKey(name="renderPropertiesEdit", profileId="educ", targetObjectType=User.class)
class RenderUserPropertiesEdit extends RenderPropertiesEditImpl {

    @Override
    List<String> getPropertyNames() {
        ["name", "email", "phoneNumber", "jobPosition", "avatarStripes"]
    }
}
