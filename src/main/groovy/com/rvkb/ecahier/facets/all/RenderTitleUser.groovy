package com.rvkb.ecahier.facets.all

import com.rvkb.ecahier.facets.FacetCategory
import com.rvkb.ecahier.model.Entry
import java.text.DateFormat
import net.sourceforge.jfacets.annotations.FacetKey
import net.sourceforge.jfacets.annotations.FacetKeyList
import woko.facets.builtin.all.RenderTitleImpl
import com.rvkb.ecahier.model.User

@FacetKey(name="renderTitle", profileId="all", targetObjectType=User.class)
@Mixin(FacetCategory)
class RenderTitleUser extends RenderTitleImpl {

    @Override
    String getPath() {
        return '/WEB-INF/jsp/all/renderTitle.jsp'
    }

    @Override
    String getTitle() {
        User u = facetContext.targetObject
        if (!u.id){
            "Ajout d'un nouvel utilisateur"
        } else {
            u.name ? u.name : u.username
        }
    }
}

