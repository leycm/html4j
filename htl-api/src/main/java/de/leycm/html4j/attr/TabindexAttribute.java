package de.leycm.html4j.attr;


import de.leycm.html4j.dom.Attribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

/**
 * Immutable record implementation of the HTML {@code tabindex} attribute.
 *
 * <p>The {@code tabindex} attribute indicates that its element can be focused,
 * and where it participates in sequential keyboard navigation.
 *
 * @param index the tab order index
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/tabindex">
 *      MDN tabindex documentation</a>
 */
public record TabindexAttribute(int index)
        implements Attribute {

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "tabindex";
    }

    @Override
    @Contract(pure = true)
    public @NonNull String value() {
        return String.valueOf(index);
    }

}
