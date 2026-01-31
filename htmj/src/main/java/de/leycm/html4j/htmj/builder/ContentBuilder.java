package de.leycm.html4j.htmj.builder;

import de.leycm.html4j.htmj.html.Content;
import lombok.NonNull;

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
    public @NonNull P close() {
        return parent;
    }

    @Override
    public @NonNull E build() {
        return content;
    }

}
