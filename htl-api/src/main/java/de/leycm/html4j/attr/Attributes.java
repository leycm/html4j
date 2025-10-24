package de.leycm.html4j.attr;

import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.BiFunction;

public class Attributes {
    public static final HashMap<String, BiFunction<String, String, Attribute<?>>> attributes = new HashMap<>();

    public static @NotNull Set<Attribute<?>> parse(@NonNull String s) {
        Set<Attribute<?>> result = new LinkedHashSet<>();

        String regex = "(\\w[\\w-]*)\\s*(=\\s*\"([^\"]*)\"|=\\s*'([^']*)')?";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            String name = matcher.group(1);
            String value = matcher.group(3);
            if (value == null) value = matcher.group(4);
            if (value == null) value = "";

            result.add(of(name, value));
        }

        return result;
    }

    public static Attribute<?> of(@NonNull String name,
                                  @NonNull String value) {

        for (Map.Entry<String, BiFunction<String, String, Attribute<?>>>
                entry : attributes.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(name))
                return entry.getValue().apply(name, value);
        }

        return new GenericAttribute(name, value);
    }

    public static void register(@NonNull String name,
                                @NonNull BiFunction<String,
                                        String, Attribute<?>>
                                        creator) {
        attributes.put(name, creator);
    }

}
