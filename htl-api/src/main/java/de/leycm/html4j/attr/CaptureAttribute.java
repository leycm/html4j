package de.leycm.html4j.attr;

import de.leycm.html4j.dom.Attribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

/**
 * Immutable record implementation of the HTML {@code capture} attribute.
 *
 * <p>The {@code capture} attribute specifies which camera to use for capture of image or video data.
 *
 * @param captureType the capture type ("user", "environment")
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/capture">
 *      MDN capture documentation</a>
 */
public record CaptureAttribute(@NonNull String captureType)
        implements Attribute {

    /**
     * Capture type for front camera.
     */
    public static final String USER = "user";

    /**
     * Capture type for rear camera.
     */
    public static final String ENVIRONMENT = "environment";

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "capture";
    }

    @Override
    @Contract(pure = true)
    public @NonNull String value() {
        return captureType;
    }
}
