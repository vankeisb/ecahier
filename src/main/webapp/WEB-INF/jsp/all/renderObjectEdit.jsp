<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="w" tagdir="/WEB-INF/tags/woko" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="o" value="${renderObjectEdit.facetContext.targetObject}"/>
<div class="wokoObject">

<div class="page-header">
    <h1 class="wokoObjectTitle">
        <w:includeFacet targetObject="${o}" facetName="renderTitle"/>
        <div class="pull-right">
            <w:includeFacet targetObject="${o}" facetName="renderLinksEdit"/>
        </div>
    </h1>
</div>

    <w:includeFacet targetObject="${o}" facetName="renderPropertiesEdit"/>
</div>