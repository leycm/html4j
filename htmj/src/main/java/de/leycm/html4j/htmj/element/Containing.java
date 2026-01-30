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
        boolean hasChildren = !children.isEmpty();
        boolean isPretty = context.getSystem().isPrettyPrint();
        boolean hasTextOnly = hasChildren && children.stream().allMatch(c -> c instanceof TextContent);
        
        // Opening tag with indentation
        context.appendIndent()
               .append('<').append(tag).append('>');

        if (hasChildren) {
            if (isPretty) {
                context.appendLine();
                
                // Render children with proper indentation
                for (Node child : children) {
                    context.appendIndent().append("  "); // 2 spaces for child indentation
                    child.render(context, indent + 1);
                    context.appendLine();
                }
                
                // Add closing tag with proper indentation
                context.appendIndent();
            } else {
                // Compact mode - render all on one line
                for (Node child : children) {
                    child.render(context, 0);
                }
            }
        }
        
        // Closing tag
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
