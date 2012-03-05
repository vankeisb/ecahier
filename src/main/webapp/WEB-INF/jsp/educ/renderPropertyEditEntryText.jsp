<script type="text/javascript">
    dojo.require("dijit.Editor");
</script>
<input type="hidden" name="object.text" value="${renderPropertyValueEdit.propertyValue}" id="entryText"/>
<div data-dojo-type="dijit.Editor" id="text">
    ${renderPropertyValueEdit.propertyValue}
    <script type="dojo/method" data-dojo-event="onKeyUp" data-dojo-args="evt">
        dojo.attr(dojo.byId("entryText"), "value", this.get('value'));
    </script>
</div>
