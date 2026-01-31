package de.leycm.html4j.htmj.element;

import de.leycm.html4j.htmj.html.Node;
import lombok.NonNull;

public class RootElement extends Containing {
    private static final @NonNull String NAME = "html";

    public RootElement() {
        super(NAME);
    }

    public RootElement(final @NonNull Node... children) {
        super(NAME, children);
    }
}