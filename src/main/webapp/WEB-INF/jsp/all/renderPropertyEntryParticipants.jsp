<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${renderPropertyValue.propertyValue}" var="p" varStatus="s">
    <a href="${pageContext.request.contextPath}/view/User/${p.id}"><c:out value="${p.username}"/></a><c:if test="${not s.last}">, </c:if>
</c:forEach>