<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/woko/jsp/taglibs.jsp"%>
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