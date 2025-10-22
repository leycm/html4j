package de.leycm.html4j.attr;

import de.leycm.html4j.util.BooleanAttribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

/**
 * Immutable record implementation of the HTML {@code hidden} boolean attribute.
 *
 * <p>The {@code hidden} attribute indicates that the element is not yet, or is no longer, relevant.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/hidden">
 *      MDN hidden documentation</a>
 */
public record HiddenAttribute(boolean hidden)
        implements BooleanAttribute {

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "hidden";
    }

    @Override
    public boolean is() {
        return hidden;
    }

}
