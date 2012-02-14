package com.rvkb.ecahier.facets.usager

import com.rvkb.ecahier.model.User
import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.builtin.all.RenderPropertiesEditImpl
import net.sourceforge.jfacets.IInstanceFacet
import com.rvkb.ecahier.facets.FacetCategory

@FacetKey(name="renderPropertiesEdit", profileId="usager", targetObjectType=User.class)
@Mixin(FacetCategory)
class RenderUserPropertiesEdit extends RenderPropertiesEditImpl implements IInstanceFacet{

    @Override
    List<String> getPropertyNames() {
        return ["name", "email", "phoneNumber", "jobPosition", "avatarStripes"]
    }

    boolean matchesTargetObject(Object targetObject) {
        return currentUser.equals(targetObject)
    }


}
