package de.leycm.html4j.attr;

import de.leycm.html4j.dom.Attribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Immutable record implementation of the HTML {@code src} attribute.
 *
 * <p>The {@code src} attribute specifies the URL of the embedded content.
 *
 * @param uri the source URI
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/img#attr-src">
 *      MDN src documentation</a>
 */
public record SrcAttribute(@NonNull URI uri)
        implements Attribute {

    public SrcAttribute(String uriStr)
            throws URISyntaxException {
        this(new URI(uriStr));
    }

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "href";
    }

    @Override
    public @NonNull String value() {
        return uri.toString();
    }

}
