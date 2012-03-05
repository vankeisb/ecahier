dojo.provide("ecahier.UserLink");
dojo.require("dojo.cache");
dojo.require("dijit._Widget");
dojo.require("dijit._Templated");

dojo.declare("ecahier.UserLink", [ dijit._Widget, dijit._Templated ], {
    templateString: dojo.cache("ecahier", "UserLink.html"),

    baseUrl:'',
    smallImage: false,

    buildRendering: function() {
        this._imgSize = this.smallImage ? 18 : 36;
        this._userKey = this.user.id || this.user._wokoInfo.key;
        this._userTitle = this.user.username || this.user._wokoInfo.title;
        this.inherited('buildRendering', arguments);
    }

});