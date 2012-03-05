<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/woko/jsp/taglibs.jsp"%>
<c:set var="o" value="${actionBean.object}"/>
<w:facet facetName="layout" targetObject="${o}"/>
<w:facet targetObject="${o}" facetName="renderTitle"/>
<c:set var="currentUserId" value="${layout.currentUserId}"/>
<fmt:message var="pageTitle" key="app.ecahier.educ.home.pageTitle"/>
<s:layout-render name="${layout.layoutPath}" layout="${layout}" pageTitle="${pageTitle}">
    <s:layout-component name="body">

        <div class="page-header">
            <h1>
                <fmt:message key="app.ecahier.educ.home.title"/>
                <small><fmt:message key="app.ecahier.educ.home.subtitle"/></small>
            </h1>
        </div>

        <div class="row">
            <div id="entries" class="span12">
                <div class="span6">
                    <span class="loader">
                        <fmt:message key="app.ecahier.common.loadEntries"/>
                    </span>
                </div>
            </div>
        </div>

        <div id="moreEntries" style="display: none;" class="btn">
            <fmt:message key="app.ecahier.common.nextEntries"/>
        </div>

        <script type="text/javascript">

            dojo.require("ecahier.EntryListItem");

            dojo.addOnLoad(function() {
                var cuid = ${currentUserId};
                var cntr = dojo.byId("entries");
                var page = 1;
                var pageSize = 10;
                var totalSize = null;
                var cli = new woko.rpc.Client("${pageContext.request.contextPath}");

                var moreEntries = dojo.byId('moreEntries');

                var populateEntries = function(entries) {
                    dojo.forEach(entries, function(entry) {
                        var editable = cuid == cli.getWokoKey(entry.createdBy);
                        var eli = new ecahier.EntryListItem({
                            baseUrl: "${pageContext.request.contextPath}",
                            entry: entry,
                            editLink: editable
                        });
                        eli.startup();
                        cntr.appendChild(eli.domNode);
                    });
                    // handle moreEntries link visibility
                    var disp = 'none';
                    dojo.style(moreEntries,
                      "display",
                      totalSize > page * pageSize ? 'block' : 'none');
                };

                var fetchEntries = function() {
                    cli.findObjects(
                      "Entry",
                      {
                          content: {
                            "facet.resultsPerPage": pageSize,
                            "facet.page": page
                          },
                          onSuccess: function(resp) {
                            if (page==1) {
                                dojo.empty(cntr);
                                totalSize = resp.totalSize;
                                if (totalSize==0) {
                                    cntr.innerHTML = '<div class="alert alert-info"><h4 class="alert-heading">Base vide !</h4>' +
                                      "La base de donn&eacute;es est vide. Aucune entrée trouvée.";
                                }
                            }
                            page++;
                            populateEntries(resp.items);
                          },
                          onError: function(resp) {
                            // TODO
                            alert('An error occured.');
                        }
                    });
                };

                fetchEntries();

                dojo.connect(moreEntries, 'onclick', fetchEntries);

            });
        </script>

    </s:layout-component>
</s:layout-render>