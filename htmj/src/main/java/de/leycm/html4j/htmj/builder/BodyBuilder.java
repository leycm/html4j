package de.leycm.html4j.htmj.builder;

import de.leycm.html4j.htmj.element.BodyElement;
import lombok.NonNull;

public class BodyBuilder extends TreeBuilder<BodyBuilder, RootBuilder, BodyElement> {

    protected BodyBuilder(RootBuilder parent) {
        super(parent);
    }

    @Override
    protected @NonNull BodyElement constructElement() {
        return new BodyElement();
    }

}
