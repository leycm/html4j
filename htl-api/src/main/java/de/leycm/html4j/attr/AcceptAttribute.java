package de.leycm.html4j.attr;

import de.leycm.html4j.dom.Attribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

/**
 * Immutable record implementation of the HTML {@code accept} attribute.
 *
 * <p>The {@code accept} attribute specifies the types of files that the server accepts.
 *
 * @param fileTypes the accepted file types (e.g., "image/*", ".pdf", "audio/*")
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input/file#accept">
 *      MDN accept documentation</a>
 */
public record AcceptAttribute(@NonNull String fileTypes) implements Attribute {

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "accept";
    }

    @Override
    @Contract(pure = true)
    public @NonNull String value() {
        return fileTypes;
    }

}
