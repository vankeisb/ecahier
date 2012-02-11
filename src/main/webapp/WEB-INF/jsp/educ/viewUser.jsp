<%@ page import="com.rvkb.ecahier.facets.educ.ViewUser" %>
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

<%
    ViewUser view = (ViewUser)request.getAttribute("view");
    WokoFacetContext fctx = view.getFacetContext();
    User user = (User)fctx.getTargetObject();

%>

<s:layout-render name="${layout.layoutPath}" layout="${layout}" pageTitle="${pageTitle}">
    <s:layout-component name="body">

        <%-- User name--%>
        <div class="page-header">
            <h1>${renderTitle.title}</h1>
            <div class="pull-right">
                <w:includeFacet targetObject="${o}" facetName="renderLinks"/>
            </div>
        </div>

        <%-- First display avatar and some info--%>
        <div class="row">
            <%-- Avatar--%>
            <div class="span3">
                <img src="${cp}/avatar/User/<%=user.getId()%>" alt="avatar"/>
            </div>

            <%-- Infos --%>
            <div class="span6">
                <% if (user.getName() == null){%>
                    <strong>Vous devriez éditer votre profil !</strong>
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

        <h1>Toutes les entrées <small>(32)</small></h1>

    </s:layout-component>
</s:layout-render>

