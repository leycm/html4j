package de.leycm.html4j.htmj.element;

import de.leycm.html4j.htmj.html.Element;

import de.leycm.html4j.htmj.render.RenderContext;
import de.leycm.html4j.htmj.render.RenderSystem;
import lombok.NonNull;

public class SelfClosing implements Element {
    private final @NonNull String tag;

    public SelfClosing(final @NonNull String tag) {
        this.tag = tag;
    }

    public @NonNull String getTag() {
        return tag;
    }

    @Override
    public String toString() {
        return render(RenderSystem.COMPACT.createContext(), 0).toString();
    }

    @Override
    public @NonNull RenderContext render(@NonNull RenderContext context, int indent) {
        return context.appendIndent().append('<').append(tag).append(" />");
    }
}
