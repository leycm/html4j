package de.leycm.html4j.attr;

import de.leycm.html4j.dom.Attribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

/**
 * Immutable record implementation of the HTML {@code minlength} attribute.
 *
 * <p>The {@code minlength} attribute defines the minimum number of characters
 * required in the input element.
 *
 * @param length the minimum number of characters
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/minlength">
 *      MDN minlength documentation</a>
 */
public record MinlengthAttribute(int length)
        implements Attribute {

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "minlength";
    }

    @Override
    @Contract(pure = true)
    public String value() {
        return String.valueOf(length);
    }
}
