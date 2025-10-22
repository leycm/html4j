package de.leycm.html4j.attr;

import de.leycm.html4j.dom.Attribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

/**
 * Immutable record implementation of the HTML {@code min} attribute.
 *
 * <p>The {@code min} attribute specifies the minimum value for an input element.
 *
 * @param value the minimum value
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/min">
 *      MDN min documentation</a>
 */
public record MinAttribute(@NonNull String value)
        implements Attribute {

    /**
     * Creates a MinAttribute with a numeric value.
     *
     * @param value the minimum numeric value
     */
    public MinAttribute(int value) {
        this(String.valueOf(value));
    }

    /**
     * Creates a MinAttribute with a decimal value.
     *
     * @param value the minimum decimal value
     */
    public MinAttribute(double value) {
        this(String.valueOf(value));
    }

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "min";
    }

    @Override
    @Contract(pure = true)
    public @NonNull String value() {
        return value;
    }
}