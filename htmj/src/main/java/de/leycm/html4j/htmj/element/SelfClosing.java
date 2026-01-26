package de.leycm.html4j.htmj.element;

import de.leycm.html4j.htmj.html.Element;
import de.leycm.html4j.htmj.render.RenderConfig;

import lombok.NonNull;

public class SelfClosing implements Element {
    private final @NonNull String tag;

    public SelfClosing(final @NonNull String tag) {
        this.tag = tag;
    }

    @Override
    public @NonNull StringBuilder render(
            final @NonNull RenderConfig config,
            final @NonNull StringBuilder out,
            final int indent
    ) {
        out.append(config.indentOf(indent));
        return config.voidTag(out, tag);
    }

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
