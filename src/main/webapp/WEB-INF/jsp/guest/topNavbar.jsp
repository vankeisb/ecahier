<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="w" tagdir="/WEB-INF/tags/woko" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<div class="nav-collapse pull-right">
    <ul class="nav nav-pills">
        <li>
            <a href="${cp}/login">
                <i class="icon-user icon-white"></i>
                <fmt:message key="woko.layout.login"/>
            </a>
        </li>
    </ul>
</div>