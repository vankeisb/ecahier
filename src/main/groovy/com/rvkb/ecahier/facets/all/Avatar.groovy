package com.rvkb.ecahier.facets.all

import net.sourceforge.jfacets.annotations.FacetKey
import com.rvkb.ecahier.model.User
import woko.facets.BaseResolutionFacet
import net.sourceforge.stripes.action.Resolution
import net.sourceforge.stripes.action.ActionBeanContext
import net.sourceforge.stripes.action.StreamingResolution

@FacetKey(name="avatar", profileId="all", targetObjectType=User.class)
class Avatar extends BaseResolutionFacet {

    private static getBytes() {
        def stream = Avatar.class.getResourceAsStream("/unknown.jpg")
        ByteArrayOutputStream bos = new ByteArrayOutputStream()
        stream.withReader { r ->
            bos.withWriter { w ->
                w << r
            }
        }
        return bos.toByteArray()
    }

    static final byte[] DEFAULT_AVATAR_BYTES = getBytes();

    Resolution getResolution(ActionBeanContext actionBeanContext) {
        User user = facetContext.targetObject
        def avatarBytes = user.avatar
        if (avatarBytes==null) {
            // use default avatar
            avatarBytes = DEFAULT_AVATAR_BYTES
        }
        return new StreamingResolution("image/jpeg", new ByteArrayInputStream(avatarBytes))
    }


}
