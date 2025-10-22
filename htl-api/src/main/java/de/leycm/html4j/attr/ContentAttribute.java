package de.leycm.html4j.attr;

import de.leycm.html4j.dom.Attribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

/**
 * Immutable record implementation of the HTML {@code content} attribute.
 *
 * <p>The {@code content} attribute provides the value associated with the http-equiv or name attribute.
 * Commonly used in meta elements.
 *
 * @param value the content value
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/meta#attr-content">
 *      MDN content documentation</a>
 */
public record ContentAttribute(@NonNull String value) implements Attribute {

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "content";
    }

    @Override
    @Contract(pure = true)
    public @NonNull String value() {
        return value;
    }
}
