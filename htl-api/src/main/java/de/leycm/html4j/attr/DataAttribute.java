package de.leycm.html4j.attr;

import de.leycm.html4j.dom.Attribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

/**
 * Immutable record implementation of the HTML {@code data-*} attribute.
 *
 * <p>Custom data attributes for storing extra information on HTML elements.
 *
 * @param name the data attribute name without "data-" prefix
 * @param value the data value to store
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/data-*">
 *      MDN data-* documentation</a>
 */
public record DataAttribute(@NonNull String name, @NonNull String value)
        implements Attribute {

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "data-" + name;
    }

    @Override
    @Contract(pure = true)
    public @NonNull String value() {
        return value;
    }
}