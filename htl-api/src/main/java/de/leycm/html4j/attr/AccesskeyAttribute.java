package de.leycm.html4j.attr;

import de.leycm.html4j.dom.Attribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

/**
 * Immutable record implementation of the HTML {@code accesskey} attribute.
 *
 * <p>The {@code accesskey} attribute specifies a shortcut key to activate/focus an element.
 * The exact behavior depends on the browser and operating system.
 *
 * @param key the keyboard key to use as access key (single character recommended)
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/accesskey">
 *      MDN accesskey documentation</a>
 */
public record AccesskeyAttribute(@NonNull String key) implements Attribute {

    /**
     * Returns the HTML attribute name "accesskey".
     *
     * @return the string "accesskey", never {@code null}
     */
    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "accesskey";
    }

    @Override
    @Contract(pure = true)
    public @NonNull String value() {
        return key;
    }
}
