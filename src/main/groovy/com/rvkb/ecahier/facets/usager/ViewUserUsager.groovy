package com.rvkb.ecahier.facets.usager

import com.rvkb.ecahier.model.User
import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.builtin.developer.ViewImpl

@FacetKey(name="view", profileId="usager", targetObjectType=User.class)
class ViewUserUsager extends ViewImpl {}
