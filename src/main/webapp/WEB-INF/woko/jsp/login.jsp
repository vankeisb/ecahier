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
                    <small>My best slogan here...</small>
                </h1>
                <p>
                    Forcément la meilleure App !
                </p>
                <p>
                    Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah<br/>
                    Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah <br/>
                    Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah <br/>
                    Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah
                </p>
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