package de.leycm.html4j.htmj.render;

import lombok.Builder;
import lombok.Getter;
import org.apache.commons.text.StringEscapeUtils;

@Builder
public class RenderSystem {
    private final String indentString;
    @Getter
    private final boolean prettyPrint;
    @Getter
    private final boolean escapeContent;
    private final String lineSeparator;

    public static final RenderSystem COMPACT = new RenderSystem("", false, true, "");

    public static final RenderSystem PRETTY = new RenderSystem("  ", true, true, "\n");

    private RenderSystem(String indentString, boolean prettyPrint, boolean escapeContent, String lineSeparator) {
        this.indentString = indentString;
        this.prettyPrint = prettyPrint;
        this.escapeContent = escapeContent;
        this.lineSeparator = lineSeparator;
    }

    public RenderContext createContext() {
        return new RenderContext(
            new StringBuilder(),
            prettyPrint ? lineSeparator : "",
            this
        );
    }

    public String escape(String content) {
        if (content == null || !escapeContent) {
            return content;
        }
        return StringEscapeUtils.escapeHtml4(content);
    }

    public String indentOf(int level) {
        if (!prettyPrint || level <= 0) {
            return "";
        }
        return indentString.repeat(level);
    }
}
