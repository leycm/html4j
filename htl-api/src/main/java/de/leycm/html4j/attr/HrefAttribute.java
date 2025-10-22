package de.leycm.html4j.attr;

import de.leycm.html4j.dom.Attribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

import java.net.URI;
import java.net.URISyntaxException;

public record HrefAttribute(@NonNull URI uri)
        implements Attribute {

    public HrefAttribute(String uriStr)
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
