<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ec" tagdir="/WEB-INF/tags" %>
<c:forEach items="${renderPropertyValue.propertyValue}" var="p">
    <ec:userlink user="${p}"/>
</c:forEach>