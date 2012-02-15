<%@ page import="woko.Woko" %>
<%@ page import="woko.facets.builtin.Search" %>
<%@ page import="com.rvkb.ecahier.model.User" %>
<%@ page import="com.rvkb.ecahier.model.Entry" %>
<%@ page import="com.rvkb.ecahier.woko.CompassResultIteratorWithHighlight" %>
<%@ page import="com.rvkb.ecahier.woko.EcahierStore" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="w" tagdir="/WEB-INF/tags/woko" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ec" tagdir="/WEB-INF/tags" %>
<w:facet facetName="layout"/>
<s:layout-render name="${layout.layoutPath}" layout="${layout}" pageTitle="Recherche">
    <s:layout-component name="body">
        <%
            Woko woko = Woko.getWoko(application);
            EcahierStore store = (EcahierStore) woko.getObjectStore();
            Search search = (Search) request.getAttribute("search");
            CompassResultIteratorWithHighlight results = (CompassResultIteratorWithHighlight) search.getResults();
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
                        <h2>Résultats de votre recherche
                            <small>(<%=totalSize%> trouvés)</small>
                        </h2>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>

        <%
            int resultNum = results.getStart();
            while (results.hasNext()) {
                Object result = results.next();
                if (result instanceof User) {
                    User u = (User) result;
                    String name = u.getName();
        %>
        <div class="row">
            <div class="span12 srUser">
                <h3>
                    <a href="${pageContext.request.contextPath}/view/User/<%=u.getId()%>">
                        <%=u.getUsername()%>
                    </a>
                </h3>
                <span>
                    <img src="${pageContext.request.contextPath}/avatar/User/<%=u.getId()%>" width="32px" height="32px"
                         alt="avatar"/>
                    <% if (name != null) { %>
                        <c:out value="<%=name%>"/>
                    <% } %>
                </span>
            </div>
        </div>
        <%
        } else if (result instanceof Entry) {
            Entry e = (Entry) result;
            // re-hydrate object (compass-detached) for accessing non indexed fields
            e = (Entry) store.load(store.getClassMapping(e.getClass()), Long.toString(e.getId()));
            String hl = results.getHighlightedFragment(resultNum);
        %>
        <div class="row">
            <div class="span12 srEntry">
                <h3>
                    <a href="${pageContext.request.contextPath}/view/Entry/<%=e.getId()%>">
                        <fmt:formatDate value="<%=e.getCreationDate()%>"/>
                    </a>
                </h3>
                <ec:userlink user="<%=e.getCreatedBy()%>" smallImage="true"/> -
                <c:forEach var="p" items="<%=e.getParticipants()%>" varStatus="s">
                    <ec:userlink user="${p}" smallImage="true"/>
                </c:forEach>
                <br/>
                <% if (hl != null) { %>
                    <%=hl%>
                <% } else { %>
                    <%=e.getText()%>
                <% } %>
            </div>
        </div>

        <%
                }
                resultNum++;
            }
        %>

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

