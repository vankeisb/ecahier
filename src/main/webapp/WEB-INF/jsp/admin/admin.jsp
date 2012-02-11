<%@ page import="com.rvkb.ecahier.facets.admin.Admin" %>
<%@ page import="woko.persistence.ResultIterator" %>
<%@ page import="com.rvkb.ecahier.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="w" tagdir="/WEB-INF/tags/woko" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="o" value="${actionBean.object}"/>
<w:facet facetName="layout" targetObject="${o}"/>
<w:facet targetObject="${o}" facetName="renderTitle"/>
<c:set var="currentUserId" value="${layout.currentUserId}"/>
<fmt:message var="pageTitle" key="woko.admin.pageTitle"/>
<s:layout-render name="${layout.layoutPath}" layout="${layout}" pageTitle="${pageTitle}">
    <s:layout-component name="body">

        <%
            Admin admin = (Admin)request.getAttribute("admin");
            ResultIterator results = admin.getUsers();
            int totalSize = results.getTotalSize();
            int resultsPerPage = admin.getResultsPerPage();
            int nbPages = totalSize / resultsPerPage;
            int p = admin.getPage();
            if (totalSize % resultsPerPage != 0) {
              nbPages++;
            }
        %>

        <div class="page-header">
            <h1>
                <fmt:message key="woko.admin.title"/>
                <div class="pull-right">
                    <s:link href="/save" class="btn btn-small"><s:param name="className" value="User"/>
                        <i class="icon-plus"></i>
                        Ajouter un utilisateur
                    </s:link>
                </div>
            </h1>
        </div>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>Nom</th>
                <th>Username</th>
                <th>Roles</th>
                <th>Actions</th>
            </tr>
            </thead>

            <tbody>

            <%
                while (results.hasNext()){
                    User u = (User)results.next();
            %>
            <c:set var="id" value="<%=u.getId()%>"/>

            <tr>
                <td><%=u.getName()%></td>
                <td><%=u.getUsername()%></td>
                <td><%=u.getRoles()%></td>
                <td>
                    <div class="btn-group">
                      <s:link class="btn btn-small" href="/view/User/${id}"><i class="icon-eye-open"></i>Voir</s:link>
                      <s:link class="btn btn-small" href="/edit/User/${id}"><i class="icon-edit"></i>Editer</s:link>
                      <s:link class="btn btn-small" href="/delete/User/${id}"><i class="icon-trash"></i>Supprimer</s:link>
                    </div>
                </td>
            </tr>
            <%}%>
            </tbody>
        </table>



    </s:layout-component>
</s:layout-render>