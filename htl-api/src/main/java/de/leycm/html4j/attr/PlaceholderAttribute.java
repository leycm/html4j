package de.leycm.html4j.attr;

import de.leycm.html4j.dom.Attribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

/**
 * Immutable record implementation of the HTML {@code placeholder} attribute.
 *
 * <p>The {@code placeholder} attribute specifies a short hint that describes
 * the expected value of an input field.
 *
 * @param text the placeholder text
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/placeholder">
 *      MDN placeholder documentation</a>
 */
public record PlaceholderAttribute(@NonNull String text)
        implements Attribute {

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "placeholder";
    }

    @Override
    @Contract(pure = true)
    public @NonNull String value() {
        return text;
    }
}
