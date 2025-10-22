package de.leycm.html4j.attr;

import de.leycm.html4j.util.BooleanAttribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

/**
 * Immutable record implementation of the HTML {@code contenteditable} attribute.
 *
 * <p>The {@code contenteditable} attribute indicates whether the element is editable by the user.
 *
 * @param editable true if the element is editable, false otherwise
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/contenteditable">
 *      MDN contenteditable documentation</a>
 */
public record ContenteditableAttribute(boolean editable)
        implements BooleanAttribute {

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "contenteditable";
    }

    @Override
    public boolean is() {
        return editable;
    }
}