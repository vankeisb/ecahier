<%@ page import="woko.facets.WokoFacetContext" %>
<%@ page import="woko.Woko" %>
<%@ page import="com.rvkb.ecahier.model.User" %>
<%@ page import="com.rvkb.ecahier.facets.users.ViewUser" %>
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
            <strong><fmt:message key="ecahier.usager.profil.noinfo"/> </strong>
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
