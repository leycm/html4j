package de.leycm.html4j.css;

import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

public class GenericStyle extends HtmlStyle<String> {
    public GenericStyle(@NonNull String name,
                        @Nullable String value) {
        super(name, value);
    }
}
