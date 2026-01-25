package de.leycm.html4j.html;

import lombok.Data;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents an Element that is not self-closing.
 *
 * <p>A Node is an {@link Element} that contain one or more sub {@link Content}
 * <h6>How does it look in HTML?</h6>
 * <pre>
 * &lt;p&gt;This is a simple text.&lt;/p&gt;
 * </pre>
 * The node is <b>"&lt;p&gt;"</b> and <b>"&lt;/p&gt;"</b> and contains the text content as a child.
 *
 * @see Element
 */
@Data
public final class Node implements Element {
    private final @NonNull String tag;
    private final @NonNull Set<Content> children;

    public Node(@NonNull String tag, @NonNull Content @NonNull... children) {
        this.tag = tag;
        this.children = Set.of(children);
    }

    public Node(@NonNull String tag) {
        this.tag = tag;
        this.children = new HashSet<>();
    }

    public void add(final @NonNull Content content) {
        children.add(content);
    }

    public void contains(final @NonNull Content content) {
        children.remove(content);
    }

    public void remove(final @NonNull Content content) {
        children.remove(content);
    }

    public void remove(final @NonNull String id) {
        for (Content child : children) {
            if (!(child instanceof Element element)) continue;
            // todo: return element.is(id);
        }
    }

    @Override
    public @NonNull StringBuilder render(final @NonNull StringBuilder out, final int indent) {
        // todo: impl of children install
        return out.append(indentOf(indent));
    }

    @Override
    public @NonNull String tag() {
        return tag;
    }

}
