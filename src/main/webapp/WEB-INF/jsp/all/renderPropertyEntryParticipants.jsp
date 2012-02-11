<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
    dojo.require("ecahier.UserLink");
</script>
<c:forEach items="${renderPropertyValue.propertyValue}" var="p" varStatus="s">
    <span data-dojo-type="ecahier.UserLink"
          data-dojo-props="user: {_key:${p.id}, _title:'${p.username}'}, baseUrl: '${pageContext.request.contextPath}'"></span>
</c:forEach>