dojo.provide("ecahier.UserLink");
dojo.require("dojo.cache");
dojo.require("dijit._Widget");
dojo.require("dijit._Templated");

dojo.declare("ecahier.UserLink", [ dijit._Widget, dijit._Templated ], {
    templateString: dojo.cache("ecahier", "UserLink.html"),

    baseUrl:'',

    _onClick: function() {
    },

    buildRendering: function() {
        this.inherited('buildRendering', arguments);
    }



});