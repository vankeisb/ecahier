dojo.provide("ecahier.EntryListItem");

dojo.require("dojo.cache");
dojo.require("dijit._Widget");
dojo.require("dijit._Templated");
dojo.require("ecahier.UserLink");

dojo.declare("ecahier.EntryListItem", [ dijit._Widget, dijit._Templated ], {
    templateString: dojo.cache("ecahier", "EntryListItem.html"),
    widgetsInTemplate: true,
    //  your custom code goes here

    buildRendering: function() {
        var participants = this.entry.participants;
        if (participants && participants.length>0) {
            var s = "";
            for (var i=0 ; i<participants.length ; i++) {
                var p = participants[i];
                s+= p._title;
                if (i<participants.length-1) {
                    s+= ", ";
                }
            }
            this.participantsStr = s;
            this.participantsCls = "withPeople";
        } else {
            this.participantsStr = "Pas de participants";
            this.participantsCls = "withoutPeople";
        }
        this.inherited('buildRendering', arguments);
    }

});