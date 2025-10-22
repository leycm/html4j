package de.leycm.html4j.attr;

import de.leycm.html4j.dom.Attribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

/**
 * Immutable record implementation of the HTML {@code lang} attribute.
 *
 * <p>The {@code lang} attribute specifies the language of the element's content.
 *
 * @param language the language code (e.g., "en", "de", "fr")
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/lang">
 *      MDN lang documentation</a>
 */
public record LangAttribute(@NonNull String language)
        implements Attribute {

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "lang";
    }

    @Override
    @Contract(pure = true)
    public @NonNull String value() {
        return language;
    }
}