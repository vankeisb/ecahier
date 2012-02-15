package com.rvkb.ecahier.facets.educ

import com.rvkb.ecahier.model.Entry
import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.builtin.all.RenderPropertyValueEditStripesText
import com.rvkb.ecahier.model.User

@FacetKey(name="renderPropertyValueEdit_participants", profileId="educ", targetObjectType=Entry.class)
class RenderPropertyEntryParticipantsEdit extends RenderPropertyValueEditStripesText {

    @Override
    String getPath() {
        '/WEB-INF/jsp/educ/renderPropertyEditEntryParticipants.jsp'
    }

    String getDefaultValue() {
        def users = propertyValue
        def res = "["
        if (users) {
            for (int i=0 ; i<users.size() ; i++) {
                res += "{"
                User user = users.get(i);
                res += "username: '$user.username', _key: ${user.id}, name:'${user.name}'"
                res += "}"
                if (i<users.size()-1) {
                    res += ", "
                }
            }
        }
        res += "]"
        return res
    }


}
