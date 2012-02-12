package com.rvkb.ecahier.facets.all

import woko.facets.builtin.all.RenderLinksImpl
import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.builtin.all.Link
import woko.facets.WokoFacetContext
import woko.Woko
import javax.servlet.http.HttpServletRequest
import woko.persistence.ObjectStore
import woko.facets.builtin.Edit
import woko.facets.builtin.Delete
import woko.facets.builtin.Json
import net.sourceforge.stripes.controller.StripesFilter
import woko.actions.WokoLocalizationBundleFactory

@FacetKey(name="renderLinks", profileId="educ")
class RenderObjectLinks extends RenderLinksImpl {

    @Override
    String getPath() {
        '/WEB-INF/jsp/all/renderObjectLinks.jsp'
    }

    // Override Woko links to add Bootstrap Icon as link css class
    public List<Link> getLinks() {
        List<Link> links = new ArrayList<Link>();
        WokoFacetContext facetContext = getFacetContext();
        Woko woko = getFacetContext().getWoko();
        Object o = facetContext.getTargetObject();
        Class<?> oc = o.getClass();
        HttpServletRequest request = getRequest();
        ObjectStore store = woko.getObjectStore();

        // Get Localization Bundle to internationalize links
        WokoLocalizationBundleFactory localizationBundle = (WokoLocalizationBundleFactory)StripesFilter.getConfiguration().getLocalizationBundleFactory();

        // display edit link if object can be edited (use instanceof because could be a login required facet)
        Object editFacet = woko.getFacet("edit", request, o, oc);
        if (editFacet instanceof Edit) {
            String className = store.getClassMapping(oc);
            String key = store.getKey(o);
            if (key!=null) {
                // Get internationalized link label
                String editLabel = localizationBundle.getFormFieldBundle(facetContext.request.getLocale()).getString("ecahier.links.edit")
                links.add(new Link("edit/" + className + "/" + key, editLabel).setCssClass("icon-edit"));
            }
        }

        Object deleteFacet = woko.getFacet("delete", request, o, oc);
        if (deleteFacet instanceof Delete) {
            String className = store.getClassMapping(oc);
            String key = store.getKey(o);
            if (key!=null) {
                // Get internationalized link label
                String deleteLabel = localizationBundle.getFormFieldBundle(facetContext.request.getLocale()).getString("ecahier.links.delete")
                links.add(new Link("delete/" + className + "/" + key, deleteLabel).setCssClass("icon-trash"));
            }
        }

        Object jsonFacet = woko.getFacet("json", request, o, oc);
        if (jsonFacet instanceof Json) {
            String className = store.getClassMapping(oc);
            String key = store.getKey(o);
            if (key!=null) {
                // Get internationalized link label
                String jsonLabel = localizationBundle.getFormFieldBundle(facetContext.request.getLocale()).getString("ecahier.links.json")
                links.add(new Link("json/" + className + "/" + key, jsonLabel).setCssClass("icon-file"));
            }
        }

        return links;
    }


}
