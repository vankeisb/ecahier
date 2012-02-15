dojo.provide("ecahier.ParticipantsField");

dojo.require("dojo.cache");
dojo.require("dijit._Widget");
dojo.require("dijit._Templated");
dojo.require("dijit.form.Textarea");
dojo.require("ecahier.CompletionRowWidget");

dojo.declare("ecahier.ParticipantsField", [ dijit._Widget, dijit._Templated ], {
    templateString: dojo.cache("ecahier", "ParticipantsField.html"),
    widgetsInTemplate: true,

    baseUrl: '',
    users: [],
    inputFieldName: 'participants',

    _counter: 0,
    _rowWidgets: [],
    _selectedRowWidget: null,

    buildRendering: function() {
        this.inherited('buildRendering', arguments);
        // build the String to be displayed from users supplied...
        var s = "";
        for (var i = 0 ; i<this.users.length ; i++) {
            var u = this.users[i];
            s += u.username + " (" + u.name + ")";
            if (i<this.users.length-1) {
                s += ", ";
            }
        }
        this.participantsNode.setValue(s);
        this.participantsNode.domNode.setAttribute("name", this.inputFieldName);

        dojo.connect(this.participantsNode, "onKeyUp", this, "_onKeyUp");
        dojo.connect(this.participantsNode, "onKeyDown", this, "_disableNavKeys");
    },

    _isNavKey: function(evt) {
        var c = evt.keyCode;
        return (c>=37 && c<=40) || c===13;
    },

    _disableNavKeys: function(evt) {
        if (this._isNavKey(evt) && this._isCompletionOpen()) {
            evt.preventDefault();
            return true;
        }
        return false;
    },

    _moveSelectionUp: function() {
        var selectionIndex = 0;
        if (this._selectedRowWidget) {
            selectionIndex = this._rowWidgets.indexOf(this._selectedRowWidget);
            this._selectedRowWidget.setSelected(false);
        }
        if (selectionIndex>0) {
            selectionIndex--;
        } else {
            selectionIndex = this._rowWidgets.length - 1;
        }
        this._selectedRowWidget = this._rowWidgets[selectionIndex];
        this._selectedRowWidget.setSelected(true);
    },

    _moveSelectionDown: function() {
        var selectionIndex = 0;
        if (this._selectedRowWidget) {
            selectionIndex = this._rowWidgets.indexOf(this._selectedRowWidget);
            this._selectedRowWidget.setSelected(false);
        }
        if (selectionIndex<this._rowWidgets.length-1) {
            selectionIndex++;
        } else {
            selectionIndex = 0;
        }
        this._selectedRowWidget = this._rowWidgets[selectionIndex];
        this._selectedRowWidget.setSelected(true);
    },

    onItemSelected: function(rowWidget) {
        var itemText = rowWidget.item.username + " (" + rowWidget.item.name + ")";
        // obtain selections
        var pn = this.participantsNode;
        var value = pn.getValue();
        var caretPos = pn.domNode.selectionStart;
        var start = value.substring(0, caretPos);
        var end = value.substring(caretPos, value.length);
        var i = start.lastIndexOf(",");
        if (i>=0) {
            if (i<start.length-1) {
                start = start.substring(0, i+1);
                start += ' ';
            }
        } else {
            start = '';
        }
        var all = start + itemText + end;
        pn.setValue(all);

        this._closeCompletion();
    },

    _onKeyUp: function(evt) {
        this._counter++;

        if (evt.keyCode===27) {
            // escape
            this._closeCompletion();
        } else if (evt.keyCode===13) {
            // enter
            if (this._isCompletionOpen()) {
                // choice selected, fire
                this.onItemSelected(this._selectedRowWidget);
            }
        } else {
            if (this._isNavKey(evt)) {
                if (this._isCompletionOpen()) {
                    // move selection in the completion list
                    if (evt.keyCode===40) {
                        this._moveSelectionDown();
                    } else if (evt.keyCode===38) {
                        this._moveSelectionUp();
                    }
                }
                return;
            }
            var capturedCount = this._counter;
            setTimeout(dojo.hitch(this, function() {
                var newCount = this._counter;
                if (newCount===capturedCount) {
                    var value = this.participantsNode.getValue() || "";
                    // retrieve caret offset TODO check browser compat ! looks magical...
                    var caretPos = this.participantsNode.domNode.selectionStart;
                    if (caretPos >= 0) {
                        // react only when we know where the caret is
                        var s = value;
                        if (caretPos < value.length) {
                            s = s.substring(0, caretPos);
                        }
                        // we have everything up to the caret : fire the completion !
                        this._fireCompletion(s, capturedCount);
                    }
                }
            }), 200);
        }
    },

    _fireCompletion: function(prefix, capturedCount) {
        if (this._lastPrefix != prefix) {

            // find last comma & trim
            var lastCommaIndex = prefix.lastIndexOf(",");
            if (lastCommaIndex!=-1) {
                prefix = prefix.substring(lastCommaIndex+1, prefix.length);
            }
            prefix = dojo.trim(prefix);
            // we have the prefix for searching, let's go

            // set position
            var fieldPos = dojo.position(this.domNode, true);
            dojo.style(this.completionBoxNode, {
                top: fieldPos.y + fieldPos.h,
                left: fieldPos.x
            });

            // show if needed
            dojo.removeClass(this.completionBoxNode, "completionHidden");

            // load message
            this.completionBoxNode.innerHTML = "Chargement...";

            // populate with rows
            this._populateCompletion(prefix, capturedCount);

        }
    },

    _isCompletionOpen: function() {
        return this.completionBoxNode &&
          !dojo.hasClass(this.completionBoxNode, "completionHidden");
    },

    _populateCompletion: function(prefix, capturedCount) {
        prefix = prefix || "";
        var sanitizedPrefix = prefix.toLowerCase();
        var cli = new woko.rpc.Client({ baseUrl: this.baseUrl });
        cli.invokeFacet({
            facetName: "usercompletion",
            handleAs: "json",
            content: {
                "facet.criteria": sanitizedPrefix
            },
            error: function() {
                // TODO
                alert("an error occured");
            },
            load: dojo.hitch(this, function(results) {
                if (this._counter===capturedCount) {
                    this._lastPrefix = prefix;
                    dojo.empty(this.completionBoxNode);
                    var items = results.items;
                    var hasRows = false;
                    var isFirstRow = true;
                    this._rowWidgets = []; // TODO dispose previous widgets
                    dojo.forEach(items, dojo.hitch(this, function(item) {
                        // check if the item matches completion criterias
                        var title = item._title;
                        if (sanitizedPrefix==="" || title.toLowerCase().indexOf(sanitizedPrefix)!=-1) {
                            hasRows = true;
                            var itemWidget = new ecahier.CompletionRowWidget({
                                owner: this,
                                item: item,
                                prefix: sanitizedPrefix,
                                baseUrl: this.baseUrl
                            });
                            this._rowWidgets.push(itemWidget);
                            itemWidget.startup();
                            this.completionBoxNode.appendChild(itemWidget.domNode);
                            if (isFirstRow) {
                                itemWidget.setSelected(true);
                                this._selectedRowWidget = itemWidget;
                                isFirstRow = false;
                            }
                            dojo.connect(itemWidget, 'onItemClicked', dojo.hitch(this, function(item) {
                                // item clicked : select it and close completion
                                this._selectedRowWidget.setSelected(false);
                                this._selectedRowWidget = item;
                                this.onItemSelected(item);
                            }));
                        }
                    }));
                    if (!hasRows) {
                        this.completionBoxNode.innerHTML = "Pas de r&eacute;sultats";
                    }
                }
            })
        });
    },

    _closeCompletion: function(byPassFocus) {
        if (this._isCompletionOpen()) {
            dojo.addClass(this.completionBoxNode, "completionHidden");
        }
        if (!byPassFocus) {
            dijit.focus(this.domNode);
        }
    }

});
