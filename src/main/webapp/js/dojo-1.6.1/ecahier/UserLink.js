dojo.provide("ecahier.UserLink");

dojo.declare("ecahier.UserLink", [ dijit._Widget, dijit._Templated ], {
    templateString: dojo.cache("ecahier", "UserLink.html"),

    baseUrl:'',

    _onClick: function() {
    },

    buildRendering: function() {
        this.inherited('buildRendering', arguments);
    }



});