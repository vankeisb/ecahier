dojo.provide("ecahier.ParticipantsField");

dojo.require("dojo.cache");
dojo.require("dijit._Widget");
dojo.require("dijit._Templated");
dojo.require("dijit.form.Textarea");

dojo.declare("ecahier.ParticipantsField", [ dijit._Widget, dijit._Templated ], {
    templateString: dojo.cache("ecahier", "ParticipantsField.html"),
    widgetsInTemplate: true,

    baseUrl: '',
    users: [],

    _counter: 0,

    buildRendering: function() {
        this.inherited('buildRendering', arguments);
        // build the String to be displayed from users supplied...
        var s = "";
        for (var i = 0 ; i<this.users.length ; i++) {
            var u = this.users[i];
            s += u.username;
            if (i<this.users.length-1) {
                s += ", ";
            }
        }
        this.participantsNode.setValue(s);

        dojo.connect(this.participantsNode, "onKeyUp", this, "_onKeyUp");
    },

    _onKeyUp: function(evt) {
        this._counter++;
        if (evt.keyCode===27) {
            // escape
            this._closeCompletion();
        } else {
            var capturedCount = this._counter;
            setTimeout(dojo.hitch(this, function() {
                var newCount = this._counter;
                if (newCount===capturedCount) {
                    var value = this.participantsNode.getValue() || "";
                    // retrieve caret offset TODO check browser compat ! looks magical...
                    var caretPos = this.participantsNode.domNode.selectionStart;
                    if (caretPos > 0) {
                        // react only when we know where the caret is
                        var s = value;
                        if (caretPos < value.length) {
                            s = s.substring(0, caretPos);
                        }
                        // we have everything up to the caret : fire the completion !
                        this._fireCompletion(s);
                    }
                }
            }), 1000);
        }
    },

    _fireCompletion: function(prefix) {
        console.log(prefix);
        // find last comma & trim
        var lastCommaIndex = prefix.lastIndexOf(",");
        if (lastCommaIndex!=-1) {
            prefix = prefix.substring(lastCommaIndex+1, prefix.length);
        }
        prefix = dojo.trim(prefix);
        // we have the prefix for searching, let's go
        var fieldPos = dojo.position(this.domNode);
        dojo.style(this.completionBoxNode, {
            top: fieldPos.y + fieldPos.h,
            left: fieldPos.x
        });
        dojo.removeClass(this.completionBoxNode, "completionHidden");
        this.completionBoxNode.innerHTML = "Chargement...";
    },

    _closeCompletion: function() {
        dojo.addClass(this.completionBoxNode, "completionHidden");
        dijit.focus(this.domNode);
    }

});
