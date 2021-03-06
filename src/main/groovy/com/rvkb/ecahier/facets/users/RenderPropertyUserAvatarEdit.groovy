package com.rvkb.ecahier.facets.users

import net.sourceforge.jfacets.annotations.FacetKey
import net.sourceforge.stripes.action.FileBean
import woko.facets.builtin.RenderPropertyValueEdit
import woko.facets.builtin.all.RenderPropertyValueImpl
import net.sourceforge.jfacets.annotations.FacetKeyList

@FacetKeyList(
    keys=[
    @FacetKey(name="renderPropertyValueEdit", profileId="educ", targetObjectType=FileBean.class),
    @FacetKey(name="renderPropertyValueEdit", profileId="usager", targetObjectType=FileBean.class)
    ]
)
class RenderPropertyUserAvatarEdit extends RenderPropertyValueImpl implements RenderPropertyValueEdit {

    public String getPath() {
        return "/WEB-INF/jsp/educ/renderPropertyUserAvatarEdit.jsp";
    }
}
