package de.leycm.html4j.attr;

import de.leycm.html4j.util.BooleanAttribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

/**
 * Immutable record implementation of the HTML {@code multiple} boolean attribute.
 *
 * <p>The {@code multiple} attribute indicates that the user is allowed to
 * enter multiple values in the input element.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/multiple">
 *      MDN multiple documentation</a>
 */
public record MultipleAttribute(boolean multiple)
        implements BooleanAttribute {

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "multiple";
    }


    @Override
    public boolean is() {
        return multiple;
    }
}
