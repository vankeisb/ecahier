<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="w" tagdir="/WEB-INF/tags/woko" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="o" value="${actionBean.object}"/>
<w:facet facetName="layout" targetObject="${o}"/>
<w:facet targetObject="${o}" facetName="renderTitle"/>
<fmt:message var="pageTitle" key="woko.guest.home.pageTitle"/>
<s:layout-render name="${layout.layoutPath}" layout="${layout}" pageTitle="${pageTitle}">
    <s:layout-component name="body">
        <h1>Accueil</h1>

        <script type="text/javascript">

            dojo.require("ecahier.EntryListItem");

            dojo.addOnLoad(function() {

                var createEntryElement = function(entry) {

                    var eli = new ecahier.EntryListItem({
                        entry: entry
                    });
                    eli.startup();

//                    var liText = entry.creationDate + " | " +
//                      entry.text + " | ";
//                    dojo.forEach(entry.participants, function(user) {
//                        liText += user._title + " ";
//                    });
//                    var newNode = document.createElement("li");
//                    newNode.innerHTML = liText;
                    return eli.domNode;
                };

                var cli = new woko.rpc.Client({baseUrl:"${pageContext.request.contextPath}"});
                <%-- populate the entries list --%>
                cli.find({
                    className: "Entry",

                    load: function(resp) {
                        var cntr = dojo.byId("entries");
                        dojo.empty(cntr);
                        var items = resp.items;
                        dojo.forEach(items, function(item) {
                            cntr.appendChild(createEntryElement(item));
                        });
                    },

                    error: function(resp) {
                        // TODO
                        alert('An error occured.');
                    }
                });
            });
        </script>

        <div id="entries">
            Chargement des entrées...
        </div>

    </s:layout-component>
</s:layout-render>