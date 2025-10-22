package de.leycm.html4j.attr;

import de.leycm.html4j.dom.Attribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;


/**
 * Immutable record implementation of the HTML {@code step} attribute.
 *
 * <p>The {@code step} attribute specifies the interval between legal numbers in an input field.
 *
 * @param step the step interval
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/step">
 *      MDN step documentation</a>
 */
public record StepAttribute(@NonNull String step)
        implements Attribute {

    /**
     * Creates a StepAttribute with a numeric value.
     *
     * @param step the step value as integer
     */
    public StepAttribute(int step) {
        this(String.valueOf(step));
    }

    /**
     * Creates a StepAttribute with a decimal value.
     *
     * @param step the step value as double
     */
    public StepAttribute(double step) {
        this(String.valueOf(step));
    }

    /**
     * Special value for any step.
     */
    public static final String ANY = "any";

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "step";
    }

    @Override
    @Contract(pure = true)
    public @NonNull String value() {
        return step;
    }
}