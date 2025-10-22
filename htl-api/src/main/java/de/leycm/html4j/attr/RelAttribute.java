package de.leycm.html4j.attr;

import de.leycm.html4j.dom.Attribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

/**
 * Immutable record implementation of the HTML {@code rel} attribute.
 *
 * <p>The {@code rel} attribute specifies the relationship between the current document
 * and the linked resource.
 *
 * @param relationship the relationship type
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/rel">
 *      MDN rel documentation</a>
 */
public record RelAttribute(@NonNull String relationship) implements Attribute {

    /**
     * Common relationship types.
     */
    public static final String STYLESHEET = "stylesheet";
    public static final String ICON = "icon";
    public static final String PRELOAD = "preload";
    public static final String NO_FOLLOW = "nofollow";
    public static final String NO_OPENER = "noopener";
    public static final String NO_REFERRER = "noreferrer";

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "rel";
    }

    @Override
    @Contract(pure = true)
    public @NonNull String value() {
        return relationship;
    }
}
