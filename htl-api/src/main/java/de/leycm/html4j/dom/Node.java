package de.leycm.html4j.dom;

import de.leycm.html4j.html.Element;
import de.leycm.html4j.html.TextNode;
import lombok.NonNull;

/**
 * Base interface for all HTML document nodes.
 *
 * <p>Nodes can be elements, text, comments, or other document fragments.
 * This interface provides the contract for serializing nodes to HTML.
 *
 * @see Element
 * @see TextNode
 */
public interface Node {

    /**
     * Converts this node to its HTML representation with proper indentation.
     *
     * @param indent the indentation level (number of spaces)
     * @return formatted HTML string
     */
    @NonNull String toHtml(int indent);

    /**
     * Creates an indentation string for pretty-printing HTML.
     *
     * @param level the indentation level
     * @return indentation string (2 spaces per level)
     */
    default @NonNull String indent(int level) {
        return "  ".repeat(Math.max(0, level));
    }

    /**
     * Converts this node to compact HTML without indentation.
     *
     * @return compact HTML string
     */
    default @NonNull String toHtml() {
        return toHtml(0);
    }
}