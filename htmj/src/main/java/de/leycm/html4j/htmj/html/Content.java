package de.leycm.html4j.htmj.html;

import de.leycm.html4j.htmj.render.RenderContext;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

public interface Content extends Node {

    String content();

    @Override
    default @NonNull RenderContext render(final @NonNull RenderContext context) {
        context.append(this.content());
        return context;
    }

    default boolean equals(final @Nullable Content other) {
        if (other == null) return false;
        if (other == this) return true;
        return this.content().equals(other.content());
    }

    default boolean equals(final @Nullable String other) {
        if (other == null) return false;
        return this.content().equals(other);
    }

}
