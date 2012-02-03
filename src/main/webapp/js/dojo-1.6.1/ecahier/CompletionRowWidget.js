dojo.provide("ecahier.CompletionRowWidget");

dojo.require("dojo.cache");
dojo.require("dijit._Widget");
dojo.require("dijit._Templated");

dojo.declare("ecahier.CompletionRowWidget", [ dijit._Widget, dijit._Templated ], {

    templateString: dojo.cache("ecahier", "CompletionRowWidget.html"),

    item: null,
    prefix: '',
    highlightedTitle: '',

    CSS_CLASS_SELECTED: 'completionRowSelected',

    _highlight: function(bodyText, searchTerm, highlightStartTag, highlightEndTag) {
        if (!bodyText) {
            return "";
        }
        if (!searchTerm) {
            return bodyText;
        }
        // the highlightStartTag and highlightEndTag parameters are optional
        if ((!highlightStartTag) || (!highlightEndTag)) {
            highlightStartTag = "<font style='color:blue; background-color:yellow;'>";
            highlightEndTag = "</font>";
        }
        // find all occurences of the search term in the given text,
        // and add some "highlight" tags to them (we're not using a
        // regular expression search, because we want to filter out
        // matches that occur within HTML tags and script blocks, so
        // we have to do a little extra validation)
        var newText = "";
        var i = -1;
        var lcSearchTerm = searchTerm.toLowerCase();
        var lcBodyText = bodyText.toLowerCase();
        while (bodyText.length > 0) {
            i = lcBodyText.indexOf(lcSearchTerm, i + 1);
            if (i < 0) {
                newText += bodyText;
                bodyText = "";
            } else {
                // skip anything inside an HTML tag
                if (bodyText.lastIndexOf(">", i) >= bodyText.lastIndexOf("<", i)) {
                // skip anything inside a <script> block
                    if (lcBodyText.lastIndexOf("/script>", i) >= lcBodyText.lastIndexOf("<script", i)) {
                        newText += bodyText.substring(0, i) + highlightStartTag + bodyText.substr(i, searchTerm.length) + highlightEndTag;
                        bodyText = bodyText.substr(i + searchTerm.length);
                        lcBodyText = bodyText.toLowerCase();
                        i = -1;
                    }
                }
            }
        }
        return newText;
    },

    buildRendering: function() {
        this.highlightedTitle = this._highlight(this.item._title, this.prefix);
        this.inherited('buildRendering', arguments);

        dojo.connect(this, 'onClick', dojo.hitch(this, function() {
            this.onItemClicked(this);
        }));
    },

    onItemClicked: function(item) {
    },

    setSelected: function(selected) {
        if (selected) {
            dojo.addClass(this.domNode, this.CSS_CLASS_SELECTED);
        } else {
            dojo.removeClass(this.domNode, this.CSS_CLASS_SELECTED);
        }
    }

});