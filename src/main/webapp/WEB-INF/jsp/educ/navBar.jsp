<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="w" tagdir="/WEB-INF/tags/woko" %>

<ul class="nav nav-pills">
    <li><a href="${pageContext.request.contextPath}/home"><fmt:message key="woko.guest.navbar.home"/></a></li>
    <li><a href="${pageContext.request.contextPath}/save/Entry">Nouvelle entree</a></li>
</ul>

<w:username var="username"/>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<div class="nav-collapse pull-right">
    <s:form action="/search" class="navbar-search">
        <input type="text" name="facet.query" class="search-query" placeholder="Search"/>
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
                                            ${username}<br/>
                                            <small>Voir mon profil</small>
                                        </h4>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                </li>
                <li class="divider"></li>
                <li><a href="${cp}/logout"><h4><fmt:message key="woko.layout.logout"/></h4></a></li>
            </ul>
        </li>
    </ul>
</div>
