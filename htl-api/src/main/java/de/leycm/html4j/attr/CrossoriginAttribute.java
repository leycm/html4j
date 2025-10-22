package de.leycm.html4j.attr;

import de.leycm.html4j.dom.Attribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

/**
 * Immutable record implementation of the HTML {@code crossorigin} attribute.
 *
 * <p>The {@code crossorigin} attribute indicates whether the resource must be fetched
 * using CORS (Cross-Origin Resource Sharing).
 *
 * @param mode the CORS mode ("anonymous", "use-credentials")
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/crossorigin">
 *      MDN crossorigin documentation</a>
 */
public record CrossoriginAttribute(@NonNull String mode) implements Attribute {

    /**
     * CORS mode for anonymous requests.
     */
    public static final String ANONYMOUS = "anonymous";

    /**
     * CORS mode for credentialed requests.
     */
    public static final String USE_CREDENTIALS = "use-credentials";

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "crossorigin";
    }

    @Override
    @Contract(pure = true)
    public @NonNull String value() {
        return mode;
    }
}
