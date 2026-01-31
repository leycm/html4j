package de.leycm.html4j.htmj.builder;

import de.leycm.html4j.htmj.element.BodyElement;
import org.jetbrains.annotations.NotNull;

public class BodyBuilder extends TreeBuilder<BodyBuilder, RootBuilder, BodyElement> {

    protected BodyBuilder(RootBuilder parent) {
        super(parent);
    }

    @Override
    protected @NotNull BodyElement constructElement() {
        return new BodyElement();
    }

}
