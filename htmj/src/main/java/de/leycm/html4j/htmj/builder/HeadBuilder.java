package de.leycm.html4j.htmj.builder;

import de.leycm.html4j.htmj.element.HeadElement;
import lombok.NonNull;

public class HeadBuilder extends TreeBuilder<HeadBuilder, RootBuilder, HeadElement> {

    protected HeadBuilder(RootBuilder parent) {
        super(parent);
    }

    @Override
    protected @NonNull HeadElement constructElement() {
        return new HeadElement();
    }

}