package com.rvkb.ecahier.facets.users

import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.builtin.all.RenderLinksImpl
import woko.facets.builtin.all.RenderLinksEditImpl
import woko.facets.builtin.all.Link
import woko.persistence.ObjectStore
import javax.servlet.http.HttpServletRequest
import woko.Woko
import woko.facets.WokoFacetContext
import net.sourceforge.stripes.controller.StripesFilter
import woko.actions.WokoLocalizationBundleFactory
import net.sourceforge.jfacets.annotations.FacetKeyList

@FacetKeyList(
    keys=[
    @FacetKey(name="renderLinksEdit", profileId="educ"),
    @FacetKey(name="renderLinksEdit", profileId="usager")
    ]
)
class RenderObjectLinksEdit extends RenderLinksEditImpl {

    @Override
    String getPath() {
        '/WEB-INF/jsp/all/renderObjectLinksEdit.jsp'
    }

    // Override Woko links to add Bootstrap Icon as link css class
    public List<Link> getLinks() {
        List<Link> links = new ArrayList<Link>();
        WokoFacetContext  facetContext = getFacetContext();
        Woko woko = getFacetContext().getWoko();
        Object o = facetContext.getTargetObject();
        Class<?> oc = o.getClass();
        HttpServletRequest request = getRequest();
        ObjectStore store = woko.getObjectStore();

        // Get Localization Bundle to internationalize links
        WokoLocalizationBundleFactory localizationBundle = (WokoLocalizationBundleFactory)StripesFilter.getConfiguration().getLocalizationBundleFactory();

        // display view link if object can be displayed
        Object viewFacet = woko.getFacet("view", request, o, oc);
        if (viewFacet!=null) {
            String className = store.getClassMapping(oc);
            String key = store.getKey(o);
            if (key!=null) {
                // Get internationalized link label
                String closeLabel = localizationBundle.getFormFieldBundle(facetContext.request.getLocale()).getString("ecahier.links.close")
                links.add(new Link("view/" + className + "/" + key, closeLabel).setCssClass("icon-remove"));
            }
        }

        Object deleteFacet = woko.getFacet("delete", request, o, oc);
        if (deleteFacet!=null) {
            String className = store.getClassMapping(oc);
            String key = store.getKey(o);
            if (key!=null) {
                // Get internationalized link label
                String deleteLabel = localizationBundle.getFormFieldBundle(facetContext.request.getLocale()).getString("ecahier.links.delete")
                links.add(new Link("delete/" + className + "/" + key, deleteLabel).setCssClass("icon-trash"));
            }
        }
        return links;
    }


}
