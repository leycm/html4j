package de.leycm.html4j.htmj.content;

import de.leycm.html4j.htmj.render.RenderSystem;
import lombok.NonNull;

public final class EscapedText
        extends StringContent {

    public EscapedText(final @NonNull String content) {
        this(RenderSystem.COMPACT, content);
    }

    public EscapedText(final @NonNull RenderSystem system,
                       final @NonNull String content) {
        super(system.escape(content));
    }

}
