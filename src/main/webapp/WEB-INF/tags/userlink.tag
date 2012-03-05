<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="w" tagdir="/WEB-INF/tags/woko" %>
<%@ attribute name="user" required="true" type="com.rvkb.ecahier.model.User" %>
<%@ attribute name="smallImage" required="false" type="java.lang.Boolean" %>
<%
    if (smallImage==null) {
        smallImage = false;
    }
%>
<w:facet facetName="renderTitle" targetObject="${user}"/>
<script type="text/javascript">
    dojo.require("ecahier.UserLink");
</script>
<span data-dojo-type="ecahier.UserLink"
      data-dojo-props="user: {_wokoInfo: {key:${user.id}, title:'${renderTitle.title}', className:'User'}, username:'${user.username}'}, baseUrl: '${pageContext.request.contextPath}', smallImage: <%=smallImage%>"></span>
