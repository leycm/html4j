package de.leycm.html4j.dom;

import de.leycm.html4j.util.StyleAttribute;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a CSS style declaration with a property name and value.
 *
 * <p>Styles are used within the {@code style} attribute to apply inline CSS
 * styling to HTML elements.
 *
 * @see StyleAttribute
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Properties_Reference">
 *      MDN CSS Properties Reference</a>
 */
public interface Style {

    /**
     * Returns the CSS property name.
     *
     * @return the property name, never {@code null}
     */
    @NonNull String name();

    /**
     * Returns the CSS property value.
     *
     * @return the property value, or {@code null} if not set
     */
    @Nullable String value();

    /**
     * Converts this style to its CSS string representation.
     *
     * @return CSS declaration string in format: {@code name: value;}
     */
    default @NonNull String toHtml() {
        String val = value();
        return val != null ? name() + ":" + val + ";" : "";
    }
}