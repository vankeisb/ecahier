<script type="text/javascript">
    dojo.require("ecahier.ParticipantsField");
</script>
${renderPropertyValue.defaultValue}
<span id="participantsField" data-dojo-type="ecahier.ParticipantsField"
      data-dojo-props="users: ${renderPropertyValueEdit.defaultValue}, baseUrl: '${pageContext.request.contextPath}', inputFieldName:'facet.participantsStr'"/>
<script type="text/javascript">
    dojo.addOnLoad(function() {
        var n = dijit.byId('participantsField').participantsNode;
        dijit.focus(n.domNode);
    });
</script>
