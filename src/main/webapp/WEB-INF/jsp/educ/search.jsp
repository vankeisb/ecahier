<%@ page import="woko.persistence.ResultIterator" %>
<%@ page import="woko.facets.builtin.RenderTitle" %>
<%@ page import="woko.Woko" %>
<%@ page import="woko.facets.builtin.Search" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="w" tagdir="/WEB-INF/tags/woko" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<w:facet facetName="layout"/>
<s:layout-render name="${layout.layoutPath}" layout="${layout}" pageTitle="Recherche">
    <s:layout-component name="body">
        <%
            Woko woko = Woko.getWoko(application);
            Search search = (Search)request.getAttribute("search");
            ResultIterator results = search.getResults();
            String query = search.getQuery();
            int totalSize = results.getTotalSize();
            int p = search.getPage();
            int resultsPerPage = search.getResultsPerPage();
            int nbPages = totalSize / resultsPerPage;
            if (totalSize % resultsPerPage != 0) {
              nbPages++;
            }
        %>
        <div class="page-header">
            <h1>
                Rechercher dans eCahier
            </h1>
        </div>

        <div class="row">
            <div class="span9">
                <s:form class="form-inline" id="searchForm" action="/search" method="GET">
                    <s:text name="facet.query" class="span6" id="searchField"/>
                    <button class="btn btn-primary" type="submit"><i class="icon-search icon-white"></i></button>
                </s:form>
            </div>
        </div>

        <div class="row">
            <div class="span12">
                <c:choose>
                    <c:when test="<%=totalSize==0%>">
                        <h2>Pas de résultats pour cette recherche</h2>
                        <p>Aucune entrée dans le cahier ne répond aux critères soumis.</p>
                    </c:when>
                    <c:otherwise>
                        <h2>Résultats de votre recherche <small>(<%=totalSize%> trouvés)</small></h2>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        <ul>
            <%
              while (results.hasNext()) {
                  Object result = results.next();
                  // compute title
                  RenderTitle renderTitle = (RenderTitle)woko.getFacet("renderTitle", request, result);
                  String title = renderTitle!=null ? renderTitle.getTitle() : result.toString();
                  // compute link if view facet is available
                  String href = null;
                  String resultKey = woko.getObjectStore().getKey(result);
                  String className = woko.getObjectStore().getClassMapping(result.getClass());
                  if (woko.getFacet("view", request, result)!=null) {
                      href = request.getContextPath() + "/view/" + className + "/" + resultKey;
                  }
            %>
                  <li>
                      <%=resultKey%> -
            <%
                  if (href!=null) {
            %>
                    <a href="<%=href%>">
            <%
                  }
            %>
                    <c:out value="<%=title%>"/>
            <%
                  if (href!=null) {
            %>
                    </a>
            <%
                  }
            %>
                      (<%=className%>)
                  </li>
            <%
              }
            %>
        </ul>

        <c:if test="<%=nbPages>1%>">
            <div class="row">
                <div class="span12">

                    <div class="pagination">
                        <ul>
                        <%
                            for (int i=1;i<=nbPages;i++) {
                                String css = "";
                                if (i==p) {
                                    css = "active";
                                }

                        %>
                            <li class="<%=css%>"><a href="${pageContext.request.contextPath}/search?facet.query=<%=query%>&facet.page=<%=i%>&facet.resultsPerPage=<%=resultsPerPage%>"><%=i%></a></li>
                        <%
                            }
                        %>
                        </ul>
                    </div>

                </div>
            </div>
        </c:if>

        <script type="text/javascript">
            dojo.require("dijit._base.focus");
            dojo.addOnLoad(function() {
                dijit.focus(dojo.byId("searchField"));
            });
        </script>

    </s:layout-component>
</s:layout-render>

