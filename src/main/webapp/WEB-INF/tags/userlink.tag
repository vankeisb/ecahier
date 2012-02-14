<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="w" tagdir="/WEB-INF/tags/woko" %>
<%@ attribute name="user" required="false" type="com.rvkb.ecahier.model.User" %>
<w:facet facetName="renderTitle" targetObject="${user}"/>
<script type="text/javascript">
    dojo.require("ecahier.UserLink");
</script>
<span data-dojo-type="ecahier.UserLink"
      data-dojo-props="user: {_key:${user.id}, _title:'${renderTitle.title}', username:'${user.username}'}, baseUrl: '${pageContext.request.contextPath}'"></span>
