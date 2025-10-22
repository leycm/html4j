package de.leycm.html4j.css;

import de.leycm.html4j.dom.Style;
import lombok.NonNull;

public record GenericStyle(@NonNull String name,
                           @NonNull String value)
        implements Style {
}
