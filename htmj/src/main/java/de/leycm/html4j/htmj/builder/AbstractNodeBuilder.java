package de.leycm.html4j.htmj.builder;

import de.leycm.html4j.htmj.html.Node;
import lombok.NonNull;

public abstract class AbstractNodeBuilder<
        SELF extends AbstractNodeBuilder<SELF, P, E>,
        P,
        E extends Node
        > implements NodeBuilder<P, E> {

    protected final P parent;

    protected AbstractNodeBuilder(P parent) {
        this.parent = parent;
    }

    @SuppressWarnings("unchecked")
    protected SELF self() {
        return (SELF) this;
    }

    @Override
    public @NonNull P close() {
        return parent;
    }
}
