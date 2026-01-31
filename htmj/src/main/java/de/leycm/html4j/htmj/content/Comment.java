package de.leycm.html4j.htmj.content;

import de.leycm.html4j.htmj.html.Content;
import de.leycm.html4j.htmj.render.RenderContext;
import de.leycm.html4j.htmj.render.RenderSystem;
import lombok.NonNull;

public class Comment extends StringContent {

    public Comment(final @NonNull String content) {
        this(RenderSystem.COMPACT, content);
    }

    public Comment(final @NonNull RenderSystem system,
                       final @NonNull String content) {
        super(system.escape(content));
    }

    @Override
    public @NonNull RenderContext render(@NonNull RenderContext context) {
        return context.append("<!-- ").append(super.content).append(" -->");
    }

}
