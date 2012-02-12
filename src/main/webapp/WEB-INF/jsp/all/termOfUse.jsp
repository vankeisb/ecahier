<%@ page import="woko.actions.auth.builtin.WokoLogin" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="w" tagdir="/WEB-INF/tags/woko" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<w:facet facetName="layout"/>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<fmt:message var="pageTitle" key="ecahier.termOfUse.pageTitle"/>
<s:layout-render name="${layout.layoutPath}" layout="${layout}" pageTitle="${pageTitle}">

    <s:layout-component name="body">
        <div class="page-header">
            <h1>
               <fmt:message key="ecahier.termOfUse.title"/>
            </h1>
        </div>

    </s:layout-component>

</s:layout-render>