package de.leycm.html4j.attr;


import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HtmlAttribute<T> implements Attribute<T> {
    private final String name;
    private final T value;

    public HtmlAttribute(@NonNull String name, @Nullable T value) {
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
    public @NotNull String string() {
        T val = value();
        return val != null ? val.toString() : "";
    }

}
