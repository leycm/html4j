package de.leycm.html4j.html;

import de.leycm.html4j.attr.*;
import de.leycm.html4j.css.Style;
import de.leycm.html4j.dom.Node;
import de.leycm.html4j.util.*;
import lombok.Getter;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

import java.util.*;

@Getter
public class Element implements Node {
    private final String tagName;
    private final List<Node> children = new ArrayList<>();
    private final Set<Attribute<?>> attributes = new LinkedHashSet<>();

    private final ClassAttribute classAttribute = new ClassAttribute();
    private final StyleAttribute styleAttribute = new StyleAttribute();
    private IdAttribute idAttribute = new IdAttribute("");

    private boolean selfClosing = false;

    public Element(@NonNull String tagName) {
        this.tagName = tagName.toLowerCase(Locale.ROOT);
    }

    // ============ ATTRIBUTES ============
    @NonNull
    public Element addAttribute(@NonNull Attribute<?> attribute) {
        if (attribute instanceof ClassAttribute cls) {
            classAttribute.addClass(cls.getClasses().toArray(new String[0]));
        } else if (attribute instanceof StyleAttribute stl) {
            styleAttribute.addStyle(stl.getStyles().toArray(new Style<?>[0]));
        } else {
            attributes.removeIf(a -> a.name().equalsIgnoreCase(attribute.name()));
            attributes.add(attribute);
        }
        return this;
    }

    @NonNull
    public Element removeAttribute(@NonNull String name) {
        if (name.equalsIgnoreCase("id")) {
            this.idAttribute = new IdAttribute("");
        } else if (name.equalsIgnoreCase("class")) {
            classAttribute.clear();
        } else if (name.equalsIgnoreCase("style")) {
            styleAttribute.clear();
        } else {
            attributes.removeIf(a -> a.name().equalsIgnoreCase(name));
        }
        return this;
    }

    public boolean hasAttribute(@NonNull String name) {
        if (name.equalsIgnoreCase("id")) return !idAttribute.string().isEmpty();
        if (name.equalsIgnoreCase("class")) return !classAttribute.getClasses().isEmpty();
        if (name.equalsIgnoreCase("style")) return !styleAttribute.getStyles().isEmpty();
        return attributes.stream().anyMatch(a -> a.name().equalsIgnoreCase(name));
    }

    @NonNull
    public Element id(@NonNull String id) {
        this.idAttribute = new IdAttribute(id);
        return this;
    }

    // ============ CLASS ============
    @NonNull
    public Element addClass(@NonNull String... classes) {
        classAttribute.addClass(classes);
        return this;
    }

    @NonNull
    public Element removeClass(@NonNull String... classes) {
        classAttribute.removeClass(classes);
        return this;
    }

    public boolean hasClass(@NonNull String cls) {
        return classAttribute.hasClass(cls);
    }

    // ============ STYLE ============
    @NonNull
    public Element addStyle(@NonNull Style<?>... styles) {
        styleAttribute.addStyle(styles);
        return this;
    }

    @NonNull
    public Element removeStyle(@NonNull String... styleNames) {
        styleAttribute.removeStyle(styleNames);
        return this;
    }

    public boolean hasStyle(@NonNull String styleName) {
        return styleAttribute.hasStyle(styleName);
    }

    // ============ CHILDREN ============
    @NonNull
    public Element append(@NonNull Node @NotNull ... nodes) {
        for (Node node : nodes) {
            if (!children.contains(node)) children.add(node);
        }
        return this;
    }

    @NonNull
    public Element removeChild(@NonNull Node node) {
        children.remove(node);
        return this;
    }

    @NonNull
    public Element clearChildren() {
        children.clear();
        return this;
    }

    @NonNull
    public Element text(@NonNull String text) {
        children.add(new TextNode(text));
        return this;
    }

    @NonNull
    public List<Node> getChildren() {
        return new ArrayList<>(children);
    }

    // ============ SELF CLOSING ============
    @NonNull
    public Element selfClosing() {
        this.selfClosing = true;
        return this;
    }

    // ============ HTML ============
    @Override
    public @NonNull String toHtml(int indent) {
        StringBuilder sb = new StringBuilder();
        String ind = "  ".repeat(Math.max(0, indent));
        sb.append(ind).append('<').append(tagName);

        Set<Attribute<?>> merged = new LinkedHashSet<>(attributes);
        if (!classAttribute.getClasses().isEmpty()) merged.add(classAttribute);
        if (!styleAttribute.getStyles().isEmpty()) merged.add(styleAttribute);
        if (!idAttribute.string().isEmpty()) merged.add(idAttribute);

        for (Attribute<?> attr : merged) {
            String val = attr.string();
            if (val.isEmpty()) continue;
            sb.append(' ').append(attr.toHtml());
        }

        if (selfClosing && children.isEmpty()) {
            sb.append(" />");
            return sb.toString();
        }

        sb.append('>');
        if (!children.isEmpty()) {
            sb.append('\n');
            for (Node child : children) {
                sb.append(child.toHtml(indent + 1)).append('\n');
            }
            sb.append(ind);
        }
        sb.append("</").append(tagName).append('>');
        return sb.toString();
    }

    @Override
    public String toString() {
        return toHtml(0);
    }
}
