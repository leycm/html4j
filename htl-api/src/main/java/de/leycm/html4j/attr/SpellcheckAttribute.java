package de.leycm.html4j.attr;

import de.leycm.html4j.util.BooleanAttribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

/**
 * Immutable record implementation of the HTML {@code spellcheck} attribute.
 *
 * <p>The {@code spellcheck} attribute indicates whether the element is to have its spelling and grammar checked.
 *
 * @param enabled true to enable spell checking, false to disable
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/spellcheck">
 *      MDN spellcheck documentation</a>
 */
public record SpellcheckAttribute(boolean enabled)
        implements BooleanAttribute {

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "spellcheck";
    }

    @Override
    public boolean is() {
        return enabled;
    }

}
