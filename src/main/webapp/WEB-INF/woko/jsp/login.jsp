<%@ page import="woko.actions.auth.builtin.WokoLogin" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/woko/jsp/taglibs.jsp"%>
<w:facet facetName="layout"/>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<fmt:message var="pageTitle" key="woko.login.pageTitle" bundle="${wokoBundle}"/>
<s:layout-render name="${layout.layoutPath}" layout="${layout}" pageTitle="${pageTitle}" skipLoginLink="true">
    <s:layout-component name="body">

        <div class="row loginPage">
            <div class="span8">

                <div class="page-header">
                    <h1 class="big">
                        <fmt:message key="ecahier.common.appTitle" />
                        <small><fmt:message key="ecahier.common.slogan"/></small>
                    </h1>
                </div>

                <div class="row">
                    <div class="span4">
                        <h2><img src="${cp}/style/images/easy.png" alt="easy"/>Facile d'accès</h2>
                        <p>
                            Accédez eCahier où que vous soyez : en établissement,
                            depuis un ordinateur équippé d'une connection internet,
                            ou même depuis votre smart-phone !
                        </p>
                    </div>

                    <div class="span4">
                        <h2><img src="${cp}/style/images/roles.png" alt="roles"/>Pour tous</h2>
                        <p>

                            eCahier s'adresse à tous les acteurs de la vie de l'établissement. Que vous soyez
                            usager, personnel encadrant ou administratif, l'interface et les fonctionnalités sont
                            spécifiques à votre rôle.
                        </p>
                    </div>
                    <div class="span4">
                        <h2><img src="${cp}/style/images/efficient.png" alt="efficient"/>Efficace</h2>
                        <p>
                            Simple et intuitif, eCahier vous donne les outils adaptés au suivi de l'activité
                            sans imposer de charge de travail supplémentaire. Saisir des entrées, naviguer dans
                            le cahier ou consulter des rapports : tout se fait en quelques clicks.
                        </p>
                    </div>
                    <div class="span4">
                        <h2><img src="${cp}/style/images/secure.png" alt="secure"/>Sécurisé</h2>
                        <p>
                            eCahier assure la confidentialité et la pérénnité de vos informations.
                            La consultation des entrées nécéssite de s'authentifier et
                            repose sur un système de permissions.
                            D'autre part, les informations stockées sont sauvegardées durablement,
                            et peuvent être restaurées en cas de perte.
                        </p>
                    </div>
                </div>
            </div>

            <div class="span4">
                <%-- The login form--%>
                <s:form beanclass="<%=WokoLogin.class%>" class="well">
                    <h4><fmt:message key="woko.login.title" bundle="${wokoBundle}"/></h4>
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