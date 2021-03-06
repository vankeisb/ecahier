package com.rvkb.ecahier.facets.users

import net.sourceforge.jfacets.annotations.FacetKey
import com.rvkb.ecahier.model.User
import woko.facets.builtin.developer.ViewImpl
import net.sourceforge.jfacets.annotations.FacetKeyList

@FacetKeyList(
    keys=[
    @FacetKey(name="view", profileId="educ", targetObjectType=User.class),
    @FacetKey(name="view", profileId="usager", targetObjectType=User.class)
    ]
)
class ViewUser extends ViewImpl {}
