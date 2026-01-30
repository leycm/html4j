package de.leycm.html4j.htmj.html;

import de.leycm.html4j.htmj.render.RenderContext;
import lombok.NonNull;

public interface Renderable {

    @NonNull
    RenderContext render(@NonNull RenderContext context, int indent);

}
