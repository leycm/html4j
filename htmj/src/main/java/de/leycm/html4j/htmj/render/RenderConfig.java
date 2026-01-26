package de.leycm.html4j.htmj.render;

import lombok.NonNull;
import org.apache.commons.text.StringEscapeUtils;

public abstract class RenderConfig {
    public static RenderConfig PRETTY = new RenderConfig(
            true,
            true,
            true
    ) {};

    public static RenderConfig COMPACT = new RenderConfig(
            false,
            false,
            false
    ) {};

    public final boolean newLines;
    public final boolean useIndentation;
    public final boolean closeSingleTags;

    protected RenderConfig(
            final boolean newLines,
            final boolean useIndentation,
            final boolean closeSingleTags
    ) {
        this.newLines = newLines;
        this.useIndentation = useIndentation;
        this.closeSingleTags = closeSingleTags;
    }

    public @NonNull StringBuilder openTag(final @NonNull StringBuilder out, final @NonNull String tagName) {
        return out.append('<').append(tagName).append('>');
    }

    public @NonNull StringBuilder closeTag(final @NonNull StringBuilder out, final @NonNull String tagName) {
        return out.append("</").append(tagName).append('>');
    }

    public @NonNull StringBuilder voidTag(final @NonNull StringBuilder out, final @NonNull String tagName) {
        out.append('<').append(tagName);

        if (closeSingleTags)
            out.append(" /");

        return out.append('>');
    }

    public @NonNull String indentOf(final int level) {
        if (!useIndentation) return "";
        return "    ".repeat(Math.max(0, level));
    }

    public @NonNull String escapeOf(final @NonNull String s) {
        if (s.isBlank()) return s;
        return StringEscapeUtils.escapeHtml4(s);
    }

}
