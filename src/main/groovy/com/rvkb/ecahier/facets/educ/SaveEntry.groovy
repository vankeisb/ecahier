package com.rvkb.ecahier.facets.educ

import net.sourceforge.jfacets.annotations.FacetKey
import com.rvkb.ecahier.model.Entry
import woko.facets.builtin.developer.SaveImpl
import net.sourceforge.stripes.action.ActionBeanContext
import com.rvkb.ecahier.facets.FacetCategory
import net.sourceforge.jfacets.IInstanceFacet
import net.sourceforge.stripes.action.Resolution
import net.sourceforge.stripes.action.RedirectResolution
import net.sourceforge.stripes.action.SimpleMessage
import net.sourceforge.stripes.action.LocalizableMessage

@FacetKey(name="save",profileId="educ",targetObjectType=Entry.class)
@Mixin(FacetCategory)
class SaveEntry extends SaveImpl implements IInstanceFacet {

    String participantsStr

    @Override
    protected void doSave(ActionBeanContext abc) {
        Entry e = facetContext.targetObject
        if (e.createdBy==null) {
            e.createdBy = currentUser
        }

        // decode participants string
        def um = facetContext.woko.userManager
        e.participants = []
        if (participantsStr) {
            participantsStr.split(",").each { fullName ->
                def username = fullName
                def i = username.indexOf('(')
                if (i!=-1) {
                    username = username.substring(0, i)
                }
                username = username.trim()
                def u = um.getUserByUsername(username);
                if (u) {
                    if (!e.participants.contains(u)) {
                        e.participants << u
                    }
                }
            }
        }

        facetContext.woko.objectStore.save(e);
        abc.messages << new LocalizableMessage("app.ecahier.entry.saved")
    }

    @Override
    protected Resolution getNonRpcResolution(ActionBeanContext abc) {
        return new RedirectResolution("/home")
    }

    boolean matchesTargetObject(Object targetObject) {
        checkTargetEntryIsOwnedByCurrentUser(targetObject)
    }

}
