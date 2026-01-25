package de.leycm.html4j.html;

import lombok.NonNull;
import org.apache.commons.text.StringEscapeUtils;

/**
 * Represents content that can be rendered to HTML.
 * This is the lowest common interface for all renderable HTML content.
 * @see Node
 * @see Element
 * @see Text
 */
public interface Content {

    /**
     * Converts this content to its HTML representation with proper indentation.
     *
     * @param out    the StringBuilder to append the rendered text
     * @param indent the indentation level (number of tabs)
     * @return out for faster and better usage
     */
    @NonNull StringBuilder render(@NonNull StringBuilder out, int indent);

    /**
     * Creates an indentation string for pretty-printing HTML.
     *
     * @param level the indentation level
     * @return indentation string (2 spaces per level)
     */
    default @NonNull String indentOf(final int level) {
        return "  ".repeat(Math.max(0, level));
    }

    /**
     * Escapes special HTML characters in a string.
     *
     * @param s the input string
     * @return the escaped string
     */
    default @NonNull String escapeOf(final @NonNull String s) {
        return StringEscapeUtils.escapeHtml4(s);
    }

}
