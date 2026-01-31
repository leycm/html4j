package de.leycm.html4j.htmj.element;

import de.leycm.html4j.htmj.html.Node;
import lombok.NonNull;

public class DivElement extends Containing {
    private static final @NonNull String NAME = "div";

    public DivElement() {
        super(NAME);
    }

    public DivElement(final @NonNull Node... children) {
        super(NAME, children);
    }
}
