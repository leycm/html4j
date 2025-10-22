package de.leycm.html4j.attr;

import de.leycm.html4j.util.BooleanAttribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

/**
 * Immutable record implementation of the HTML {@code disabled} boolean attribute.
 *
 * <p>The {@code disabled} attribute indicates that the form control is not available for interaction.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/disabled">
 *      MDN disabled documentation</a>
 */
public record DisabledAttribute(boolean disabled)
        implements BooleanAttribute {

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "disabled";
    }

    @Override
    public boolean is() {
        return disabled;
    }

}
