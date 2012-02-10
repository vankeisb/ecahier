<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="w" tagdir="/WEB-INF/tags/woko" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<w:username var="username"/>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<div class="nav-collapse pull-right">
    <s:form action="/search" class="navbar-search">
        <input type="text" name="facet.query" class="search-query" placeholder="Search"/>
    </s:form>

    <ul class="nav pull-right">

        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                <i class="icon-user icon-white"></i>
                <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
                <li>
                    <a href="#">
                        <div class="row">
                            <div class="span3">
                                <div class="row">
                                    <div class="span-one-third">
                                        <img src="${cp}/avatar/User/${topNavBar.currentUserId}" alt="avatar"/>
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