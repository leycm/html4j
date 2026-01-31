package de.leycm.html4j.htmj.registry;

import de.leycm.html4j.htmj.builder.NodeBuilder;
import de.leycm.html4j.htmj.html.Node;

import java.util.function.Function;

public final class ElementEntry<E extends Node, P extends NodeBuilder<?, E>> {

    private final String tag;
    private final Class<E> elementClass;
    private final Function<NodeBuilder<?, ?>, P> builderFactory;

    public ElementEntry(
            String tag,
            Class<E> elementClass,
            Function<NodeBuilder<?, ?>, P> builderFactory
    ) {
        this.tag = tag;
        this.elementClass = elementClass;
        this.builderFactory = builderFactory;
    }

    public String tag() {
        return tag;
    }

    public Class<E> elementClass() {
        return elementClass;
    }

    public P builder(NodeBuilder<?, ?> parent) {
        return builderFactory.apply(parent);
    }
}
