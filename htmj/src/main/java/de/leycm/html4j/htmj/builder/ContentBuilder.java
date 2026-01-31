package de.leycm.html4j.htmj.builder;

import de.leycm.html4j.htmj.html.Content;
import org.jetbrains.annotations.NotNull;

public class ContentBuilder<
        P extends NodeBuilder<?, ?>,
        E extends Content
        > implements NodeBuilder<P, E> {

    protected final P parent;
    protected final E content;

    protected ContentBuilder(P parent, E content) {
        this.parent = parent;
        this.content = content;
    }

    @Override
    public @NotNull P close() {
        return parent;
    }

    @Override
    public @NotNull E build() {
        return content;
    }

}
