dojo.provide("ecahier.EntryListItem");

dojo.require("dojo.cache");
dojo.require("dijit._Widget");
dojo.require("dijit._Templated");
dojo.require("ecahier.UserLink");
dojo.require( "dojo.date.locale" );

dojo.declare("ecahier.EntryListItem", [ dijit._Widget, dijit._Templated ], {
    templateString: dojo.cache("ecahier", "EntryListItem.html"),
    widgetsInTemplate: true,

    baseUrl: '',

    buildRendering: function() {
        this.entry.text = this.entry.text || "Pas de texte !";
        // format the creation date of the entry for display
        var d = woko.rpc.convertDate(this.entry.creationDate);
        if (d && d.getMonth) {
            this.entry._creationDateFormatted = dojo.date.locale.format(d);
        } else {
            this.entry._creationDateFormatted = '';
        }
        this.inherited('buildRendering', arguments);
        var participants = this.entry.participants;
        if (participants && participants.length>0) {
            dojo.addClass(this.participantsNode, 'withPeople');
            for (var i=0;i<participants.length;i++) {
                var p = participants[i];
                var widget = new ecahier.UserLink({ user : p , baseUrl: this.baseUrl });
                widget.startup();
                this.participantsNode.appendChild(widget.domNode);
            }
        } else {
            dojo.addClass(this.participantsNode, 'withoutPeople');
            this.participantsNode.innerHTML = "Pas de participants";
        }
        if (this.editLink) {
            dojo.addClass(this.domNode, "editable");
            var link = document.createElement("a");
            link.setAttribute("href", this.baseUrl + "/edit/Entry/" + this.entry._key);
            link.innerHTML = '<i class="icon-pencil"></i> &eacute;diter';
            dojo.addClass(link, "btn");
            this.editLinkNode.appendChild(link);
        }
    }

});