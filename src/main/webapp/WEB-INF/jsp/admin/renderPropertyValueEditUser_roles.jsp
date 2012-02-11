<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8"%>

<%@ page import="com.rvkb.ecahier.facets.admin.RenderPropertyUserRolesEdit" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%
    RenderPropertyUserRolesEdit renderPropertyValue = (RenderPropertyUserRolesEdit)request.getAttribute("renderPropertyValueEdit_roles");
    String propertyName = renderPropertyValue.getPropertyName();
    String fullFieldName = "object." + propertyName;
%>

<s:select name="<%=fullFieldName%>">
    <s:options-collection collection="${renderPropertyValueEdit_roles.roles}"/>
</s:select>
