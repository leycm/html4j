package de.leycm.html4j.attr;

import de.leycm.html4j.dom.Attribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

/**
 * Immutable record implementation of the HTML {@code form} attribute.
 *
 * <p>The {@code form} attribute specifies the form element the input element belongs to.
 *
 * @param formId the ID of the form element
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#attr-form">
 *      MDN form documentation</a>
 */
public record FormAttribute(@NonNull String formId) implements Attribute {

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "form";
    }

    @Override
    @Contract(pure = true)
    public @NonNull String value() {
        return formId;
    }
}
