<%@ include file="/WEB-INF/woko/jsp/taglibs.jsp"%>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<div class="nav-collapse pull-right">
    <ul class="nav nav-pills">
        <li>
            <a href="${cp}/login">
                <i class="icon-user icon-white"></i>
                <fmt:message key="ecahier.guest.navbar.login"/>
            </a>
        </li>
    </ul>
</div>