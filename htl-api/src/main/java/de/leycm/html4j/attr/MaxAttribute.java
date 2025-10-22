package de.leycm.html4j.attr;
import de.leycm.html4j.dom.Attribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

/**
 * Immutable record implementation of the HTML {@code max} attribute.
 *
 * <p>The {@code max} attribute specifies the maximum value for an input element.
 *
 * @param value the maximum value
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/max">
 *      MDN max documentation</a>
 */
public record MaxAttribute(@NonNull String value)
        implements Attribute {

    /**
     * Creates a MaxAttribute with a numeric value.
     *
     * @param value the maximum numeric value
     */
    public MaxAttribute(int value) {
        this(String.valueOf(value));
    }

    /**
     * Creates a MaxAttribute with a decimal value.
     *
     * @param value the maximum decimal value
     */
    public MaxAttribute(double value) {
        this(String.valueOf(value));
    }

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "max";
    }

    @Override
    @Contract(pure = true)
    public @NonNull String value() {
        return value;
    }
}