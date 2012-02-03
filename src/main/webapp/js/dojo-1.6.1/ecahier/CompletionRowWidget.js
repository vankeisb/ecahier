dojo.provide("ecahier.CompletionRowWidget");

dojo.require("dojo.cache");
dojo.require("dijit._Widget");
dojo.require("dijit._Templated");

dojo.declare("ecahier.CompletionRowWidget", [ dijit._Widget, dijit._Templated ], {

    templateString: dojo.cache("ecahier", "CompletionRowWidget.html")

});