package de.leycm.html4j.attr;

import de.leycm.html4j.util.BooleanAttribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

/**
 * Immutable record implementation of the HTML {@code draggable} attribute.
 *
 * <p>The {@code draggable} attribute indicates whether the element can be dragged.
 *
 * @param draggable true if the element is draggable, false otherwise
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/draggable">
 *      MDN draggable documentation</a>
 */
public record DraggableAttribute(boolean draggable)
        implements BooleanAttribute {

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "draggable";
    }

    @Override
    public boolean is() {
        return draggable;
    }

}