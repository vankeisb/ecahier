<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="w" tagdir="/WEB-INF/tags/woko" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<w:username var="username"/>

<s:layout-definition>
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

        </head>
        <body class="claro">
            <div id="wrap">
                <div id="header-space">
                    <div id="logo">
                        <span id="logoStart">e</span>Cahier
                    </div>
                    <div id="userInfo">
                        <c:if test="${skipLoginLink==null}">
                            <span id="authInfo">
                                <c:choose>
                                    <c:when test="${username != null}">
                                        <img src="${cp}/avatar/User/${layout.currentUserId}" alt="avatar"/><strong>${username}</strong> -
                                        <a href="${cp}/logout"><fmt:message key="woko.layout.logout"/> </a>
                                    </c:when>
                                    <c:otherwise>
                                        <fmt:message key="woko.layout.notLogged"/>
                                        <a href="${cp}/login"><fmt:message key="woko.layout.login"/> </a>
                                    </c:otherwise>
                                </c:choose>
                            </span>
                        </c:if>
                    </div>
                    <%--
                    <div id="wokoSearchBox">
                        <s:form action="/search">
                            <s:text name="facet.query"/>
                            <s:submit name="search"/>
                        </s:form>
                    </div>
                    --%>
                </div>
                <div id="navbar">
                    <div id="nbar">
                        <w:includeFacet facetName="navBar" targetObject="${layout.facetContext.targetObject}"/>
                    </div>
                </div>
                <div id="content-wrap">
                    <div id="content">
                        <s:messages/>
                        <s:errors/>
                        <s:layout-component name="body"/>
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>
            <div id="divider-line"></div>
        </body>
    </html>
</s:layout-definition>