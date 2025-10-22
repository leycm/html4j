package de.leycm.html4j.attr;

import de.leycm.html4j.dom.Attribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

public record IdAttribute(@NonNull String id)
        implements Attribute {

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "id";
    }

    @Override
    public @NonNull String value() {
        return id;
    }

}
