package de.leycm.html4j.attr;

import de.leycm.html4j.util.BooleanAttribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

/**
 * Immutable record implementation of the HTML {@code readonly} boolean attribute.
 *
 * <p>The {@code readonly} attribute indicates that the user cannot modify the value of the input.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/readonly">
 *      MDN readonly documentation</a>
 */
public record ReadonlyAttribute(boolean readonly)
        implements BooleanAttribute {

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "readonly";
    }


    @Override
    public boolean is() {
        return readonly;
    }
}
