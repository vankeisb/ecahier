<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="w" tagdir="/WEB-INF/tags/woko" %>

<ul class="nav nav-pills">
    <li><a href="${pageContext.request.contextPath}/home"><fmt:message key="ecahier.educ.navbar.home"/></a></li>
    <li><a href="${pageContext.request.contextPath}/save/Entry"><fmt:message key="ecahier.educ.navbar.addEntry"/></a></li>
    <c:if test="${navBar.admin}">
        <li><a href="${pageContext.request.contextPath}/admin"><fmt:message key="ecahier.admin.navbar.admin"/></a>
    </c:if>
</ul>

<w:username var="username"/>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<div class="nav-collapse pull-right">
    <s:form action="/search" class="navbar-search">
        <input type="text" name="facet.query" class="search-query" placeholder="<fmt:message key='ecahier.common.navbar.search'/>"/>
    </s:form>

    <ul class="nav pull-right">

        <li class="dropdown">
            <a href="/#" class="dropdown-toggle" data-toggle="dropdown">
                <i class="icon-user icon-white"></i>
                <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
                <li>
                    <a href="${cp}/view/User/${layout.currentUserId}">
                        <div class="row">
                            <div class="span3">
                                <div class="row">
                                    <div class="span-one-third">
                                        <img src="${cp}/avatar/User/${layout.currentUserId}" alt="avatar" height="32px" width="32px"/>
                                    </div>
                                    <div class="span-two-third">
                                        <h4>
                                            ${layout.currentUserLongName}<br/>
                                            <small><fmt:message key="ecahier.common.navbar.seeProfil"/></small>
                                        </h4>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                </li>
                <li class="divider"></li>
                <li><a href="${cp}/logout"><h4><fmt:message key="ecahier.common.navbar.logout"/></h4></a></li>
            </ul>
        </li>
    </ul>
</div>
