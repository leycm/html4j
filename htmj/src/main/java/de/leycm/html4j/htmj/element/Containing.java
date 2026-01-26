package de.leycm.html4j.htmj.element;

import de.leycm.html4j.htmj.html.Element;
import de.leycm.html4j.htmj.html.Node;
import de.leycm.html4j.htmj.render.RenderConfig;

import lombok.NonNull;

import java.util.List;


public class Containing implements Element {
    private final @NonNull String tag;
    private final @NonNull List<Node> children;

    public Containing(
            final @NonNull String tag,
            final @NonNull Node... children
    ) {
        this(tag, List.of(children));
    }

    public Containing(
            final @NonNull String tag,
            final @NonNull List<Node> children
    ) {
        this.tag = tag;
        this.children = children;
    }

    @Override
    public @NonNull StringBuilder render(
            final @NonNull RenderConfig config,
            final @NonNull StringBuilder out,
            final int indent    ) {
        final String space = config.indentOf(indent);
        out.append(space);
        config.openTag(out, tag);

        for (Node child : children) {
            child.render(config, out, indent + 1);
        }

        return config.closeTag(out, tag);
    }

    @Override
    public @NonNull String getTag() {
        return tag;
    }

    @Override
    public String toString() {
        return render(RenderConfig.COMPACT,
                new StringBuilder(), 0)
                .toString();
    }

}
