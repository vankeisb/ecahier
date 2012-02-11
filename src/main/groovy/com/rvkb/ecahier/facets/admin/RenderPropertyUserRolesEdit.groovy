package com.rvkb.ecahier.facets.admin

import net.sourceforge.jfacets.annotations.FacetKey
import net.sourceforge.stripes.action.FileBean
import woko.facets.builtin.RenderPropertyValueEdit
import woko.facets.builtin.all.RenderPropertyValueImpl
import com.rvkb.ecahier.model.User

@FacetKey(name="renderPropertyValueEdit_roles", profileId="educ", targetObjectType=User.class)
class RenderPropertyUserRolesEdit extends RenderPropertyValueImpl implements RenderPropertyValueEdit {

    @Override
    public String getPath() {
        return "/WEB-INF/jsp/admin/renderPropertyValueEditUser_roles.jsp";
    }

    List<String> getRoles(){
        return ["usager","educ"]
    }
}
