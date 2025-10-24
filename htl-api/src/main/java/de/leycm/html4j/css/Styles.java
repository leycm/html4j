package de.leycm.html4j.css;

import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.BiFunction;

public class Styles {

    private static final Map<String, BiFunction<String, String, Style<?>>> registry = new HashMap<>();

    public static @NotNull Set<Style<?>> parse(@NonNull String css) {
        Set<Style<?>> result = new LinkedHashSet<>();

        String[] declarations = css.split(";");
        for (String decl : declarations) {
            decl = decl.trim();
            if (decl.isEmpty()) continue;

            String[] parts = decl.split(":", 2);
            String name = parts[0].trim();
            String value = parts.length > 1 ? parts[1].trim() : "";

            result.add(of(name, value));
        }

        return result;
    }

    public static Style<?> of(@NonNull String name,
                              @NonNull String value) {
        BiFunction<String, String, Style<?>> creator = registry.get(name.toLowerCase());
        if (creator != null) return creator.apply(name, value);
        return new GenericStyle(name, value);
    }

    public static void register(@NonNull String name,
                                @NonNull BiFunction<String,
                                        String, Style<?>>
                                        creator) {
        registry.put(name.toLowerCase(), creator);
    }

}
