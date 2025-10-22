package de.leycm.html4j.attr;

import de.leycm.html4j.dom.Attribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

/**
 * Immutable record implementation of the HTML {@code pattern} attribute.
 *
 * <p>The {@code pattern} attribute specifies a regular expression that the
 * input element's value is checked against.
 *
 * @param regex the regular expression pattern
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/pattern">
 *      MDN pattern documentation</a>
 */
public record PatternAttribute(@NonNull String regex)
        implements Attribute {

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "pattern";
    }

    @Override
    @Contract(pure = true)
    public @NonNull String value() {
        return regex;
    }
}
