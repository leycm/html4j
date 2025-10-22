package de.leycm.html4j.attr;

import de.leycm.html4j.dom.Attribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Immutable record implementation of the HTML {@code size} attribute.
 *
 * <p>The {@code size} attribute specifies the visible width of an input element.
 *
 * @param size the visible size in characters
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/size">
 *      MDN size documentation</a>
 */
public record SizeAttribute(int size) implements Attribute {

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "size";
    }

    @Override
    @Contract(pure = true)
    public @NotNull String value() {
        return String.valueOf(size);
    }

}
