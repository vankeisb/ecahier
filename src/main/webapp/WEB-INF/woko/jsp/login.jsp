<%@ page import="woko.actions.auth.builtin.WokoLogin" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="w" tagdir="/WEB-INF/tags/woko" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<w:facet facetName="layout"/>

<fmt:message var="pageTitle" key="woko.login.pageTitle"/>
<s:layout-render name="${layout.layoutPath}" layout="${layout}" pageTitle="${pageTitle}" skipLoginLink="true">
    <s:layout-component name="body">

        <div class="row">
            <div class="span8">
                <%-- Quick presentation here --%>
                <h1>
                    eCahier
                    <small>Le cahier de liaison électronique</small>
                </h1>
                <p>
                    Les dernières technologies à votre service
                </p>
                <br/><br/>

                <div class="row">
                    <div class="span1">
                        <img src="${pageContext.request.contextPath}/style/images/earth.png" width="64px"/>
                    </div>
                    <div class="span7">
                        <p>
                            Il est grand temps de sauver la planète...<br/>
                            Fini les impressions, les photocopies.
                        </p>
                    </div>
                </div>

                <br/>

                <div class="row">
                    <div class="span1">
                        <img src="${pageContext.request.contextPath}/style/images/time.png" width="64px"/>
                    </div>
                    <div class="span7">
                        <p>
                            Avec toutes les informations à porter de souris,<br/>
                            eCahier vous fera gagner un temps précieux
                        </p>
                    </div>
                </div>

                <br/>

                <div class="row">
                    <div class="span1">
                        <img src="${pageContext.request.contextPath}/style/images/users.png" width="64px"/>
                    </div>
                    <div class="span7">
                        <p>
                            Partagez avec vos collègues les informations nécessaires<br/>
                            Tous les avis comptent faites partager le votre !
                        </p>
                    </div>
                </div>

                <br/><br/>

                <span class="label label-success">New</span> eCahier est bientôt disponible

            </div>

            <div class="span4">
                <%-- The login form--%>
                <s:form beanclass="<%=WokoLogin.class%>" class="well">
                    <h4><fmt:message key="woko.login.title"/></h4>
                    <hr>
                    <s:errors/>
                    <s:hidden name="targetUrl"/>

                    <s:label for="username"/>
                    <s:text name="username" class="span3"/>

                    <s:label for="password"/>
                    <s:password name="password" class="span3"/>

                    <s:submit name="login" class="btn btn-primary"/>

                </s:form>
            </div>
        </div>
    </s:layout-component>
</s:layout-render>