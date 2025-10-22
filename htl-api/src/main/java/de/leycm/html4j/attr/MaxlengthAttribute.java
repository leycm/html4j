package de.leycm.html4j.attr;

import de.leycm.html4j.dom.Attribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Immutable record implementation of the HTML {@code maxlength} attribute.
 *
 * <p>The {@code maxlength} attribute defines the maximum number of characters
 * allowed in the input element.
 *
 * @param length the maximum number of characters
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/maxlength">
 *      MDN maxlength documentation</a>
 */
public record MaxlengthAttribute(int length)
        implements Attribute {

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "maxlength";
    }

    @Override
    @Contract(pure = true)
    public @NotNull String value() {
        return String.valueOf(length);
    }
}
