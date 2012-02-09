<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="w" tagdir="/WEB-INF/tags/woko" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="o" value="${actionBean.object}"/>
<w:facet facetName="layout" targetObject="${o}"/>
<w:facet targetObject="${o}" facetName="renderTitle"/>
<c:set var="currentUserId" value="${layout.currentUserId}"/>
<fmt:message var="pageTitle" key="woko.guest.home.pageTitle"/>
<s:layout-render name="${layout.layoutPath}" layout="${layout}" pageTitle="${pageTitle}">
    <s:layout-component name="body">
        <h1>Accueil</h1>

        <script type="text/javascript">

            dojo.require("ecahier.EntryListItem");

            dojo.addOnLoad(function() {
                var cuid = ${currentUserId};
                var cntr = dojo.byId("entries");
                var page = 1;
                var pageSize = 10;
                var cli = new woko.rpc.Client({baseUrl:"${pageContext.request.contextPath}"});

                var populateEntries = function(entries) {
                    dojo.forEach(entries, function(entry) {
                        var editable = cuid == entry.createdBy._key;
                        var eli = new ecahier.EntryListItem({
                            baseUrl: "${pageContext.request.contextPath}",
                            entry: entry,
                            editLink: editable
                        });
                        eli.startup();
                        cntr.appendChild(eli.domNode);
                        var clf = document.createElement("div");
                        dojo.addClass(clf, "clearfix");
                        cntr.appendChild(clf);
                    });
                };

                var fetchEntries = function() {
                    cli.find({
                        className: "Entry",
                        content: {
                            "facet.resultsPerPage": pageSize,
                            "facet.page": page
                        },
                        load: function(resp) {
                            if (page==1) {
                                dojo.empty(cntr);
                            }
                            populateEntries(resp.items);
                            page++;
                        },

                        error: function(resp) {
                            // TODO
                            alert('An error occured.');
                        }
                    });
                };

                fetchEntries();

                // handle "more entries" link
                var moreEntries = dojo.byId('moreEntries');
                dojo.connect(moreEntries, 'onclick', fetchEntries);

            });
        </script>

        <div id="entries">
            Chargement des entrées...
        </div>

        <div id="moreEntries">
            Suivants...
        </div>

    </s:layout-component>
</s:layout-render>