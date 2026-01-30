package de.leycm.html4j.htmj.element;

import de.leycm.html4j.htmj.html.Element;
import de.leycm.html4j.htmj.html.Node;
import de.leycm.html4j.htmj.render.RenderContext;
import de.leycm.html4j.htmj.render.RenderSystem;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Containing implements Element {
    private final @NonNull String tag;
    private final @NonNull List<Node> children;
    @Getter
    private Containing parent;

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
        this.children = new ArrayList<>(children);
        for (Node child : this.children) {
            if (child instanceof Containing) {
                ((Containing) child).parent = this;
            }
        }
    }

    @Override
    public @NonNull RenderContext render(
            final @NonNull RenderContext context,
            final int indent
    ) {
        context.appendIndent()
               .append('<').append(tag).append('>');

        if (context.getSystem().isPrettyPrint() && !children.isEmpty()) {
            context.appendLine();
        }

        for (Node child : children) {
            child.render(context, indent + 1);
        }

        if (context.getSystem().isPrettyPrint() && !children.isEmpty()) {
            context.appendIndent();
        }
        
        return context.append("</").append(tag).append('>');
    }

    @Override
    public @NonNull String getTag() {
        return tag;
    }

    public Containing add(Node node) {
        children.add(node);
        if (node instanceof Containing) {
            ((Containing) node).parent = this;
        }
        return this;
    }

    @Override
    public String toString() {
        return render(RenderSystem.COMPACT.createContext(), 0).toString();
    }
}
