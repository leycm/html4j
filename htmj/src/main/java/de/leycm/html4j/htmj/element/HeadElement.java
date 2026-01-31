package de.leycm.html4j.htmj.element;

import de.leycm.html4j.htmj.html.Node;
import lombok.NonNull;

public class HeadElement extends Containing {
    private static final @NonNull String NAME = "head";

    public HeadElement() {
        super(NAME);
    }

    public HeadElement(final @NonNull Node... children) {
        super(NAME, children);
    }

}
