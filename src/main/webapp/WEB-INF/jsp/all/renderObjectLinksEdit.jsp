<%@ taglib prefix="w" tagdir="/WEB-INF/tags/woko" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="btn-group">
    <c:forEach var="link" items="${renderLinksEdit.links}">
        <a class="btn btn-small" href="${pageContext.request.contextPath}/${link.href}">
            <i class="${link.cssClass}"></i>
            <c:out value="${link.text}"/>
        </a>
    </c:forEach>
</div>