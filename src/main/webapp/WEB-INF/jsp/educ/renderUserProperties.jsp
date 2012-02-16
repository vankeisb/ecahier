<%@ page import="com.rvkb.ecahier.facets.users.ViewUser" %>
<%@ page import="woko.facets.WokoFacetContext" %>
<%@ page import="woko.Woko" %>
<%@ page import="com.rvkb.ecahier.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="w" tagdir="/WEB-INF/tags/woko" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="o" value="${actionBean.object}"/>
<w:facet facetName="layout" targetObject="${o}"/>
<w:facet targetObject="${o}" facetName="renderTitle"/>
<c:set var="pageTitle" value="${renderTitle.title}"/>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<%
    ViewUser view = (ViewUser)request.getAttribute("view");
    WokoFacetContext fctx = view.getFacetContext();
    User user = (User)fctx.getTargetObject();

%>

<%-- First display avatar and some info--%>
<div class="row">
    <%-- Avatar--%>
    <div class="span2">
        <img src="${cp}/avatar/User/<%=user.getId()%>" alt="avatar" width="150px" height="150px"/>
    </div>

    <%-- Infos --%>
    <div class="span10">
        <% if (user.getName() == null){%>
            <strong><fmt:message key="ecahier.educ.profil.noinfo"/> </strong>
        <%}else {%>
        <address>
            <strong><%=user.getName()%></strong><br/>
            <%=user.getJobPosition()%> @ La croix rouge francaise<br/>
            Tel : <%=user.getPhoneNumber()%><br/>
            Email : <a href="mailto:<%=user.getEmail()%>"><%=user.getEmail()%></a>
        </address>
        <%}%>
    </div>
</div>

<div class="page-header">
    <h2><fmt:message key="ecahier.educ.profil.entries"/> </h2>
</div>

<%-- Display associated entries--%>
<div class="row">
    <div id="entries" class="span12">
        <div class="span6">
            <span class="loader">
                <fmt:message key="ecahier.common.loadEntries"/>
            </span>
        </div>
    </div>
</div>

<div id="moreEntries" style="display: none;" class="btn">
    <fmt:message key="ecahier.common.nextEntries"/>
</div>

<script type="text/javascript">

    dojo.require("ecahier.EntryListItem");

    dojo.addOnLoad(function() {
        var cuid = <%=user.getId()%>;
        var cntr = dojo.byId("entries");
        var page = 1;
        var pageSize = 10;
        var totalSize = null;
        var cli = new woko.rpc.Client({baseUrl:"${pageContext.request.contextPath}"});

        var moreEntries = dojo.byId('moreEntries');

        var populateEntries = function(entries) {
            dojo.forEach(entries, function(entry) {
                var editable = cuid == entry.createdBy._key;
                var eli = new ecahier.EntryListItem({
                    baseUrl: "${pageContext.request.contextPath}",
                    entry: entry,
                    editLink: editable
                });
                eli.startup();
                cntr.appendChild(eli.domNode);
            });
            // handle moreEntries link visibility
            var disp = 'none';
            dojo.style(moreEntries,
              "display",
              totalSize > page * pageSize ? 'block' : 'none');
        };

        var fetchEntries = function() {
            cli.find({
                className: "Entry",
                content: {
                    "facet.resultsPerPage": pageSize,
                    "facet.page": page,
                    "facet.user": "<%=user.getId()%>"
                },
                load: function(resp) {
                    if (page==1) {
                        dojo.empty(cntr);
                        totalSize = resp.totalSize;
                        if (totalSize==0) {
                            cntr.innerHTML = '<div class="alert alert-info"><h4 class="alert-heading">Base vide !</h4>' +
                              "La base de donn&eacute;es est vide. Aucune entrée trouvée.";
                        }
                    }
                    page++;
                    populateEntries(resp.items);
                },

                error: function(resp) {
                    // TODO
                    alert('An error occured.');
                }
            });
        };

        fetchEntries();

        dojo.connect(moreEntries, 'onclick', fetchEntries);

    });
</script>


