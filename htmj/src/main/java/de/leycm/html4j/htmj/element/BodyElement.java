package de.leycm.html4j.htmj.element;

import de.leycm.html4j.htmj.html.Node;
import lombok.NonNull;

public class BodyElement extends Containing {
    private static final @NonNull String NAME = "body";

    public BodyElement() {
        super(NAME);
    }

    public BodyElement(final @NonNull Node... children) {
        super(NAME, children);
    }
}
