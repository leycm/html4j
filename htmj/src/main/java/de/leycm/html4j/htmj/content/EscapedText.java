package de.leycm.html4j.htmj.content;

import de.leycm.html4j.htmj.render.RenderConfig;

import lombok.NonNull;

public final class EscapedText
        extends Text {

    public EscapedText(final @NonNull String content) {
        this(RenderConfig.COMPACT, content);
    }

    public EscapedText(final @NonNull RenderConfig config,
                       final @NonNull String content) {
        super(config.escapeOf(content));
    }

}
