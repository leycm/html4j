package de.leycm.html4j.attr;


import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

public class GenericAttribute extends HtmlAttribute<String> {

    public GenericAttribute(@NonNull String name,
                            @Nullable String value) {
        super(name, value);
    }

}
