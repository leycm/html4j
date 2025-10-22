package de.leycm.html4j.html;

import de.leycm.html4j.dom.Node;
import lombok.NonNull;

public record TextNode(String text) implements Node {

    public TextNode(@NonNull String text) {
        this.text = text;
    }

    private @NonNull String escape(@NonNull String s) {
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }

    @Override
    public @NonNull String toHtml(int indent) {
        return indent(indent) + escape(text);
    }

}
