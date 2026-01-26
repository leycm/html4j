package de.leycm.html4j.htmj.html;

import de.leycm.html4j.htmj.render.RenderConfig;

import lombok.NonNull;

public interface Node {

    @NonNull StringBuilder render(@NonNull RenderConfig config,
                                  @NonNull StringBuilder out,
                                  int indent
    );

}
