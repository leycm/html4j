package de.leycm.html4j.css;

import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

public class HtmlStyle<T> implements Style<T> {
    private final String name;
    private final T value;

    public HtmlStyle(@NonNull String name, @Nullable T value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public @NonNull String name() {
        return name;
    }

    @Override
    public @Nullable T value() {
        return value;
    }

    @Override
    public @NonNull String string() {
        T val = value();
        return val != null ? val.toString() : "";
    }
}
