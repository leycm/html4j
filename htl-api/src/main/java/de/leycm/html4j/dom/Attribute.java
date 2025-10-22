package de.leycm.html4j.dom;

import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents an HTML attribute with a name and optional value.
 *
 * <p>Attributes are key-value pairs that configure elements or adjust their behavior.
 * Some attributes are boolean (presence indicates true) while others have explicit values.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes">
 *      MDN HTML Attribute Reference</a>
 */
public interface Attribute {

    /**
     * Returns the attribute name.
     *
     * @return the attribute name, never {@code null}
     */
    @NonNull String name();

    /**
     * Returns the attribute value.
     *
     * @return the attribute value
     */
    @Nullable String value();

    /**
     * Converts this attribute to its HTML string representation.
     *
     * <p>For attributes with values: {@code name="value"}
     * For boolean attributes: {@code name}
     *
     * @return HTML attribute string
     */
    default @NonNull String toHtml() {
        String val = value();
        return val != null ? name() + "=\"" + escapeHtml(val) + "\"" : name();
    }

    /**
     * Escapes HTML special characters in attribute values.
     *
     * @param text the text to escape
     * @return HTML-escaped text
     */
    static @NonNull String escapeHtml(@NonNull String text) {
        return text.replace("&", "&amp;")
                .replace("\"", "&quot;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("'", "&#39;");
    }

}