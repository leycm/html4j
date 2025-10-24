package de.leycm.html4j.util;

import de.leycm.html4j.attr.Attribute;
import lombok.NonNull;

import java.util.*;

@SuppressWarnings("UnusedReturnValue")
public class ClassAttribute implements Attribute<String> {

    protected final List<String> classes = new ArrayList<>();

    @NonNull
    public ClassAttribute addClass(@NonNull String clazz) {
        if (!hasClass(clazz)) classes.add(clazz);
        return this;
    }

    @NonNull
    public ClassAttribute addClass(@NonNull String @NonNull ... clazz) {
        for (String c : clazz) addClass(c);
        return this;
    }

    @NonNull
    public ClassAttribute removeClass(@NonNull String clazz) {
        classes.removeIf(s -> s.equalsIgnoreCase(clazz));
        return this;
    }

    @NonNull
    public ClassAttribute removeClass(@NonNull String @NonNull ... clazz) {
        for (String c : clazz) removeClass(c);
        return this;
    }

    @NonNull
    public ClassAttribute clear() {
        classes.clear();
        return this;
    }

    public boolean hasClass(@NonNull String clazz) {
        return getClass(clazz) != null;
    }

    public String getClass(@NonNull String clazz) {
        for (String s : classes)
            if (s.equalsIgnoreCase(clazz)) return s;
        return null;
    }

    @NonNull
    public List<String> getClasses() {
        return new ArrayList<>(classes);
    }

    @Override
    public @NonNull String name() {
        return "class";
    }

    @Override
    public @NonNull String value() {
        return String.join(" ", classes);
    }

    @Override
    public @NonNull String string() {
        return value();
    }
}
