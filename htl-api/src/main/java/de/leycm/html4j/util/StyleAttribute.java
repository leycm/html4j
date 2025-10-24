package de.leycm.html4j.util;

import de.leycm.html4j.attr.Attribute;
import de.leycm.html4j.css.Style;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

@SuppressWarnings("UnusedReturnValue")
public class StyleAttribute implements Attribute<String> {

    protected final List<Style<?>> styles = new ArrayList<>();

    @NonNull
    public StyleAttribute addStyle(@NonNull Style<?> style) {
        if (!hasStyle(style.name())) styles.add(style);
        return this;
    }

    @NonNull
    public StyleAttribute addStyle(@NonNull Style<?> @NonNull ... style) {
        for (Style<?> s : style) addStyle(s);
        return this;
    }

    @NonNull
    public StyleAttribute removeStyle(@NonNull String name) {
        styles.removeIf(s -> s.name().equalsIgnoreCase(name));
        return this;
    }

    @NonNull
    public StyleAttribute removeStyle(@NonNull String @NonNull ... names) {
        for (String n : names) removeStyle(n);
        return this;
    }

    @NonNull
    public StyleAttribute clear() {
        styles.clear();
        return this;
    }

    public boolean hasStyle(@NonNull String name) {
        return getStyle(name) != null;
    }

    @Nullable
    public Style<?> getStyle(@NonNull String name) {
        for (Style<?> s : styles)
            if (s.name().equalsIgnoreCase(name)) return s;
        return null;
    }

    @NonNull
    public List<Style<?>> getStyles() {
        return new ArrayList<>(styles);
    }

    @Override
    public @NonNull String name() {
        return "style";
    }

    @Override
    public @NonNull String value() {
        StringBuilder css = new StringBuilder();
        styles.forEach(s -> css.append(s.toHtml()).append(" "));
        return css.toString().trim();
    }

    @Override
    public @NonNull String string() {
        return value();
    }
}