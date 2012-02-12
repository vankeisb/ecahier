
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="w" tagdir="/WEB-INF/tags/woko" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<w:username var="username"/>

<s:layout-definition>
    <!DOCTYPE html>
    <html>
    <head>
        <c:choose>
            <c:when test="${not empty pageTitle}">
                <title>${layout.appTitle} - ${pageTitle}</title>
            </c:when>
            <c:otherwise>
                <title>${layout.appTitle}</title>
            </c:otherwise>
        </c:choose>
        <c:set var="cp" value="${pageContext.request.contextPath}"/>

        <c:set var="dojoRoot" value="${cp}/js/dojo-1.6.1"/>
        <script type="text/javascript" src="${dojoRoot}/dojo/dojo.js"
                djConfig="debugAtAllCosts:true, parseOnLoad:true"></script>
        <link rel="stylesheet" type="text/css" href="${dojoRoot}/dojo/resources/dojo.css">
        <link rel="stylesheet" type="text/css" href="${dojoRoot}/dijit/themes/claro/claro.css" />
        <script type="text/javascript" src="${cp}/woko/js/woko.base.js"></script>
        <script type="text/javascript" src="${cp}/woko/js/woko.rpc.js"></script>

        <c:forEach items="${layout.cssIncludes}" var="cssLink">
            <link rel="stylesheet" href="${cp}${cssLink}" type="text/css">
        </c:forEach>
        <c:forEach items="${layout.jsIncludes}" var="jsLink">
            <script type="text/javascript" src="${cp}${jsLink}"></script>
        </c:forEach>
        <script type="text/javascript" src="${cp}/woko/js/woko.base.js"></script>
        <s:layout-component name="customCss"/>
        <s:layout-component name="customJs"/>

         <link rel="stylesheet" type="text/css" href="${cp}/style/ecahier.css">

        <%-- Use Bootstrap for UI (needs Jquery for now...) --%>
        <style type="text/css">
          body {
            padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
          }
        </style>
        <script type="text/javascript" src="${cp}/js/bootstrap/jquery.min.js"></script>
        <script type="text/javascript" src="${cp}/js/bootstrap/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="${cp}/style/boostrap/css/bootstrap.min.css">

    </head>

    <body class="claro">
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <s:link class="brand" href="/home">${layout.appTitle}</s:link>
                    <w:includeFacet facetName="navBar" targetObject="${layout.facetContext.targetObject}"/>
                </div>
            </div>
        </div>
        <div class="container">
            <s:messages/>
            <s:layout-component name="body"/>
        </div>
    </body>

</html>
</s:layout-definition>