package de.leycm.html4j.attr;

import de.leycm.html4j.dom.Attribute;
import lombok.NonNull;

public record GenericAttribute(@NonNull String name,
                               @NonNull String value)
        implements Attribute {
}
