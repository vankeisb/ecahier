dojo.provide("ecahier.EntryListItem");

dojo.require("dojo.cache");
dojo.require("dijit._Widget");
dojo.require("dijit._Templated");
dojo.require("ecahier.UserLink");

dojo.declare("ecahier.EntryListItem", [ dijit._Widget, dijit._Templated ], {
    templateString: dojo.cache("ecahier", "EntryListItem.html"),
    widgetsInTemplate: true,

    buildRendering: function() {
        this.entry.text = this.entry.text || "Pas de texte !";
        this.inherited('buildRendering', arguments);
        var participants = this.entry.participants;
        if (participants && participants.length>0) {
            dojo.addClass(this.participantsNode, 'withPeople');
            for (var i=0;i<participants.length;i++) {
                var p = participants[i];
                var widget = new ecahier.UserLink({ user : p });
                widget.startup();
                this.participantsNode.appendChild(widget.domNode);
                if (i<participants.length-1) {
                    var sepNode = document.createElement("span");
                    sepNode.innerHTML = ", ";
                    this.participantsNode.appendChild(sepNode);
                }
            }
        } else {
            dojo.addClass(this.participantsNode, 'withoutPeople');
            this.participantsNode.innerHTML = "Pas de participants";
        }
    }

});