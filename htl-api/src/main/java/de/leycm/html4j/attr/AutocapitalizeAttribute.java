package de.leycm.html4j.attr;

import de.leycm.html4j.dom.Attribute;
import lombok.Getter;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

/**
 * Immutable record implementation of the HTML {@code autocapitalize} attribute.
 *
 * <p>The {@code autocapitalize} attribute controls whether and how text input
 * is automatically capitalized as it is entered/edited by the user.
 *
 * @param behavior the capitalization behavior ("off", "none", "on", "sentences", "words", "characters")
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/autocapitalize">
 *      MDN autocapitalize documentation</a>
 */
public record AutocapitalizeAttribute(@NonNull String behavior)
        implements Attribute {

    /**
     * Valid autocapitalize behaviors.
     */
    @Getter
    public enum Behavior {
        OFF("off"),
        NONE("none"),
        ON("on"),
        SENTENCES("sentences"),
        WORDS("words"),
        CHARACTERS("characters");

        private final String value;

        Behavior(String value) {
            this.value = value;
        }

    }

    /**
     * Creates an AutocapitalizeAttribute with the specified behavior.
     *
     * @param behavior the capitalization behavior
     */
    public AutocapitalizeAttribute(@NonNull Behavior behavior) {
        this(behavior.getValue());
    }

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "autocapitalize";
    }

    @Override
    @Contract(pure = true)
    public @NonNull String value() {
        return behavior;
    }
}