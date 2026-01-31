package de.leycm.html4j.htmj.element;

import de.leycm.html4j.htmj.html.Content;
import de.leycm.html4j.htmj.html.Element;
import de.leycm.html4j.htmj.html.Node;
import de.leycm.html4j.htmj.render.RenderContext;
import de.leycm.html4j.htmj.render.RenderSystem;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public abstract class Containing implements Element {
    protected final @NonNull String tag;
    protected final @NonNull List<Node> children;
    @Getter private Containing parent;

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
    public @NonNull RenderContext render(final @NonNull RenderContext context) {
        boolean hasChildren = !children.isEmpty();
        boolean isPretty = context.getSystem().isPrettyPrint();
        boolean hasTextOnly = hasChildren && children.size() == 1
                && (children.getFirst() instanceof Content);
        // hasTextOnly is a special case where we want to avoid new lines and indentation to get something like:
        // <tag>text</tag> instead of:
        // <tag>
        //   text
        // </tag>


        if (isPretty) {
            context.appendIndent();
        }
        
        context.append('<').append(tag).append('>');

        if (hasTextOnly) {
            children.getFirst().render(context);
        } else if (hasChildren) {
            if (isPretty) {
                context.appendLine().indent();
                for (Node child : children) {
                    if (child instanceof Content) {
                        context.appendIndent();
                    }
                    child.render(context);
                    context.appendLine();
                }
                context.unindent().appendIndent();
            } else {
                for (Node child : children) {
                    child.render(context);
                }
            }
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
        return render(RenderSystem.COMPACT.createContext()).toString();
    }

}
