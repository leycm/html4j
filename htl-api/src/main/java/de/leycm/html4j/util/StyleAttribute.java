package de.leycm.html4j.util;

import de.leycm.html4j.dom.Attribute;
import de.leycm.html4j.dom.Style;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class StyleAttribute implements Attribute {

    protected final List<Style> styles = new ArrayList<>();

    @NonNull
    public StyleAttribute addStyle(@NonNull Style style) {
        styles.add(style);
        return this;
    }

    @NonNull
    public StyleAttribute addStyle(@NonNull Style... style) {
        styles.addAll(Arrays.stream(style).toList());
        return this;
    }

    public boolean hasStyle(@NonNull String name) {
        return getStyle(name) != null;
    }

    public @Nullable Style getStyle(@NonNull String name) {
        for (Style s : styles)
            if (s.name().equalsIgnoreCase(name)) return s;
        return null;
    }

    public @NonNull List<Style> getStyles() {
        return new ArrayList<>(styles);
    }

    @Override
    public @NonNull String name() {
        return "style";
    }

    @Override
    public String value() {
        StringBuilder css = new StringBuilder();
        styles.forEach(s -> css.append(s.toHtml())
                .append(' '));
        return css.toString();
    }

}