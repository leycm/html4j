package de.leycm.html4j.htmj.element;

import de.leycm.html4j.htmj.html.Node;
import lombok.NonNull;

public class ParagraphElement extends Containing {
    private static final @NonNull String NAME = "p";

    public ParagraphElement() {
        super(NAME);
    }

    public ParagraphElement(final @NonNull Node... children) {
        super(NAME, children);
    }
}