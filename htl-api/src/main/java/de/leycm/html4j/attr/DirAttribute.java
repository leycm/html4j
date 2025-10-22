package de.leycm.html4j.attr;

import de.leycm.html4j.dom.Attribute;
import lombok.Getter;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

/**
 * Immutable record implementation of the HTML {@code dir} attribute.
 *
 * <p>The {@code dir} attribute indicates the directionality of the element's text.
 *
 * @param direction the text direction ("ltr", "rtl", or "auto")
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/dir">
 *      MDN dir documentation</a>
 */
public record DirAttribute(@NonNull String direction)
        implements Attribute {

    /**
     * Text direction options.
     */
    @Getter
    public enum Direction {
        LTR("ltr"),
        RTL("rtl"),
        AUTO("auto");

        private final String value;

        Direction(String value) {
            this.value = value;
        }

    }

    /**
     * Creates a DirAttribute with the specified direction.
     *
     * @param direction the text direction
     */
    public DirAttribute(@NonNull Direction direction) {
        this(direction.getValue());
    }

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "dir";
    }

    @Override
    @Contract(pure = true)
    public @NonNull String value() {
        return direction;
    }

}
