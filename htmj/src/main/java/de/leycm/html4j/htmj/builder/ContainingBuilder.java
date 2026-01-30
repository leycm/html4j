package de.leycm.html4j.htmj.builder;

import de.leycm.html4j.htmj.element.Containing;
import de.leycm.html4j.htmj.html.Node;
import lombok.NonNull;

public abstract class ContainingBuilder<
        SELF extends ContainingBuilder<SELF, P, C>,
        P,
        C extends Containing
        > extends AbstractNodeBuilder<SELF, P, C> {

    protected final C element;

    protected ContainingBuilder(P parent, C element) {
        super(parent);
        this.element = element;
    }

    public SELF add(Node node) {
        element.add(node);
        return self();
    }

    @Override
    public @NonNull C build() {
        return element;
    }
}

