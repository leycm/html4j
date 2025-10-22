package de.leycm.html4j.attr;

import de.leycm.html4j.dom.Attribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

/**
 * Immutable record implementation of the HTML {@code autocomplete} attribute.
 *
 * <p>The {@code autocomplete} attribute indicates whether the value of the control
 * can be automatically completed by the browser.
 *
 * @param behavior the autocomplete behavior ("on", "off", or specific field names)
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/autocomplete">
 *      MDN autocomplete documentation</a>
 */
public record AutocompleteAttribute(@NonNull String behavior)
        implements Attribute {

    /**
     * Common autocomplete values.
     */
    public static final String ON = "on";
    public static final String OFF = "off";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String USERNAME = "username";
    public static final String CURRENT_PASSWORD = "current-password";
    public static final String NEW_PASSWORD = "new-password";

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "autocomplete";
    }

    @Override
    @Contract(pure = true)
    public @NonNull String value() {
        return behavior;
    }

}
