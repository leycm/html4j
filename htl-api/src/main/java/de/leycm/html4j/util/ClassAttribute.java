package de.leycm.html4j.util;

import de.leycm.html4j.dom.Attribute;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

import java.util.*;


public class ClassAttribute implements Attribute {

    protected final List<String> classes = new ArrayList<>();

    @NonNull
    public ClassAttribute addClass(@NonNull String clazz) {
        classes.add(clazz);
        return this;
    }

    @NonNull
    public ClassAttribute addClass(@NonNull String... clazz) {
        classes.addAll(Arrays.stream(clazz).toList());
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
    public @NotNull String name() {
        return "class";
    }

    @Override
    public @NonNull String value() {
        return String.join(" ", classes);
    }

}