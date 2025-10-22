package de.leycm.html4j.attr;

import de.leycm.html4j.util.BooleanAttribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

/**
 * Immutable record implementation of the HTML {@code autofocus} boolean attribute.
 *
 * <p>The {@code autofocus} attribute indicates that an element should be automatically
 * focused when the page loads.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/autofocus">
 *      MDN autofocus documentation</a>
 */
public record AutofocusAttribute(boolean auto) implements BooleanAttribute {

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "autofocus";
    }


    @Override
    public boolean is() {
        return auto;
    }
}