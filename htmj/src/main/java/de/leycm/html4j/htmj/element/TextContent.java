package de.leycm.html4j.htmj.element;

import de.leycm.html4j.htmj.html.Content;
import de.leycm.html4j.htmj.render.RenderContext;
import lombok.NonNull;

public class TextContent implements Content {
    private final String text;
    private final boolean escapeHtml;

    public TextContent(String text, boolean escapeHtml) {
        this.text = text;
        this.escapeHtml = escapeHtml;
    }

    @Override
    public String content() {
        return escapeHtml ? escapeHtml(text) : text;
    }

    private String escapeHtml(String input) {
        if (input == null) return "";
        return input
            .replace("&", "&amp;")
            .replace("<", "&lt;")
            .replace(">", "&gt;")
            .replace("\"", "&quot;")
            .replace("'", "&#39;");
    }

    @Override
    public @NonNull RenderContext render(@NonNull RenderContext context, int indent) {
        context.appendIndent().append(content());
        return context;
    }
}
