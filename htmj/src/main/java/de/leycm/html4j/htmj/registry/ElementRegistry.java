package de.leycm.html4j.htmj.registry;

import de.leycm.html4j.htmj.builder.ElementBuilder;
import de.leycm.html4j.htmj.element.DivElement;
import de.leycm.html4j.htmj.element.ParagraphElement;
import de.leycm.html4j.htmj.html.Node;

import java.util.HashMap;
import java.util.Map;

public final class ElementRegistry {

    private static final Map<String, ElementEntry<?, ?>> BY_NAME = new HashMap<>();
    private static final Map<Class<?>, ElementEntry<?, ?>> BY_CLASS = new HashMap<>();

    static {
        // todo: Initialize built-in tags like div and more here
        register(new ElementEntry<>("div", DivElement.class, parent -> ElementBuilder.create(parent, DivElement::new)));
        register(new ElementEntry<>("p", ParagraphElement.class, parent -> ElementBuilder.create(parent, ParagraphElement::new)));
    }

    private ElementRegistry() {}

    public static <E extends Node> void register(
            ElementEntry<E, ?> entry
    ) {
        BY_NAME.put(entry.tag(), entry);
        BY_CLASS.put(entry.elementClass(), entry);
    }

    @SuppressWarnings("unchecked")
    public static <E extends Node> ElementEntry<E, ?> byName(String tag) {
        return (ElementEntry<E, ?>) BY_NAME.get(tag);
    }

    @SuppressWarnings("unchecked")
    public static <E extends Node> ElementEntry<E, ?> byClass(Class<E> clazz) {
        return (ElementEntry<E, ?>) BY_CLASS.get(clazz);
    }
}

