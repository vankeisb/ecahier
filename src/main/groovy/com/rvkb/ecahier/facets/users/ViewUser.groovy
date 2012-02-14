package com.rvkb.ecahier.facets.users

import net.sourceforge.jfacets.annotations.FacetKey
import com.rvkb.ecahier.model.User
import woko.facets.builtin.developer.ViewImpl

@FacetKey(name="view", profileId="educ", targetObjectType=User.class)
class ViewUser extends ViewImpl {}
