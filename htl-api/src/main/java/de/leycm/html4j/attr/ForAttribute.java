package de.leycm.html4j.attr;

import de.leycm.html4j.dom.Attribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

/**
 * Immutable record implementation of the HTML {@code for} attribute.
 *
 * <p>The {@code for} attribute specifies which form element a label is bound to.
 *
 * @param elementId the ID of the element the label is for
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/label#attr-for">
 *      MDN for documentation</a>
 */
public record ForAttribute(@NonNull String elementId) implements Attribute {

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "for";
    }

    @Override
    @Contract(pure = true)
    public @NonNull String value() {
        return elementId;
    }
}
