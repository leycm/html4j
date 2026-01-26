package de.leycm.html4j.htmj.html;

import de.leycm.html4j.htmj.render.RenderConfig;

import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

public interface Content extends Node {

    String content();

    default @NonNull StringBuilder render(
            final @NonNull RenderConfig config,
            final @NonNull StringBuilder out,
            final int indent    ) {
        return out.append(config.indentOf(indent)).append(content());
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
