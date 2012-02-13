<%@ page import="woko.actions.auth.builtin.WokoLogin" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="w" tagdir="/WEB-INF/tags/woko" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<w:facet facetName="layout"/>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<fmt:message var="pageTitle" key="ecahier.about.pageTitle"/>
<s:layout-render name="${layout.layoutPath}" layout="${layout}" pageTitle="${pageTitle}">

    <s:layout-component name="body">
        <div class="page-header">
            <h1>
               <fmt:message key="ecahier.about.title"/>
            </h1>
        </div>

        <div class="row">
            <div class="span12">
                <h2>Qu'est-ce que eCahier ?</h2>
                <p>
                    eCahier est outil à destination des organismes de la petite enfance ayant pour but de faciliter le
                    suivi de l'activité de tous les acteurs de l'établissement.
                </p>
            </div>
        </div>

        <div class="row">
            <div class="span12">
                <h2>Nous contacter ?</h2>
                <p>
                    Une question ? Un problème ?
                </p>
                <p>
                    N'hésitez pas à nous contacter par email : <a href="mailto:ecahier@gmail.com">ecahier@gmail.com</a>
                </p>
            </div>
        </div>

    </s:layout-component>

</s:layout-render>