package de.leycm.html4j.htmj.builder;

import de.leycm.html4j.htmj.content.Comment;
import de.leycm.html4j.htmj.content.EscapedText;
import de.leycm.html4j.htmj.content.RawText;
import de.leycm.html4j.htmj.element.Containing;
import de.leycm.html4j.htmj.element.DivElement;
import de.leycm.html4j.htmj.html.Content;
import de.leycm.html4j.htmj.html.Node;
import de.leycm.html4j.htmj.registry.ElementEntry;
import de.leycm.html4j.htmj.registry.ElementRegistry;
import lombok.NonNull;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public abstract class TreeBuilder<
        SELF extends TreeBuilder<SELF, ?, ?>,
        P extends NodeBuilder<?, ?>,
        E extends Containing
        > implements NodeBuilder<P, E> {

    protected final P parent;
    private final List<NodeBuilder<SELF, ?>> children;

    @SuppressWarnings("unchecked") // simply casts this to SELF type
    protected final SELF self = (SELF) this;

    protected TreeBuilder(P parent) {
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    @Override
    public @NonNull P close() {
        return parent;
    }

    @Override
    public @NonNull E build() {
        E root = constructElement();

        for (NodeBuilder<SELF, ?> child : children) {
            Node childNode = child.build();
            root.add(childNode);
        }

        return root;
    }
    protected abstract @NonNull E constructElement();


    public @NotNull <B extends TreeBuilder<B, SELF, DivElement>> B div() {
        return element(DivElement.class);
    }

    public @NotNull SELF escaped(String text) {
        return content(new ContentBuilder<>(self, new EscapedText(text)));
    }

    @ApiStatus.Experimental
    public @NotNull SELF rawText(String text) {
        return content(new ContentBuilder<>(self, new RawText(text)));
    }

    @ApiStatus.Experimental
    public @NotNull SELF comment(String text) {
        return content(new ContentBuilder<>(self, new Comment(text)));
    }

    public  <B extends TreeBuilder<B, SELF, ?>> B element(String name) {
        ElementEntry<?, ?> entry = ElementRegistry.byName(name);
        if (entry == null)
            throw new IllegalArgumentException("Unknown tag: " + name);
        return element(entry);
    }

    public @NonNull <T extends Containing, B extends TreeBuilder<B, SELF, T>> B element(Class<T> type) {
        ElementEntry<T, ?> entry = ElementRegistry.byClass(type);
        if (entry == null)
            throw new IllegalArgumentException("Unknown tag class: " + type.getName());
        return element(entry);
    }

    @SuppressWarnings("unchecked") // must be ensured by the caller
    public @NonNull <B extends TreeBuilder<B, SELF, ?>> B element(ElementEntry<?, ?> entry) {
        if (entry == null)
            throw new IllegalArgumentException("TagEntry must not be null");
        B child = (B) entry.builder(this);
        children.add(child);
        return child;
    }

    public @NonNull <C extends Content> SELF content(NodeBuilder<SELF, C> child) {
        if (child == null)
            throw new IllegalArgumentException("ContentBuilder must not be null");
        children.add(child);
        return self;
    }

}
