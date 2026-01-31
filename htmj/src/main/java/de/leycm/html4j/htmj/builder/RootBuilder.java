package de.leycm.html4j.htmj.builder;

import de.leycm.html4j.htmj.element.BodyElement;
import de.leycm.html4j.htmj.element.HeadElement;
import de.leycm.html4j.htmj.element.RootElement;
import de.leycm.html4j.htmj.registry.ElementEntry;

import lombok.NonNull;

public final class RootBuilder extends TreeBuilder<RootBuilder, DocumentBuilder, RootElement> {
    private boolean hasHead = false;
    private boolean hasBody = false;

    public RootBuilder(@NonNull DocumentBuilder parent) {
        super(parent);
    }

    @Override
    protected @NonNull RootElement constructElement() {
        return new RootElement();
    }

    public @NonNull HeadBuilder head() {
        if (hasHead)
            throw new IllegalStateException("Document can only have one <head> element");

        hasHead = true;
        ElementEntry<HeadElement, HeadBuilder> entry = new ElementEntry<>("head", HeadElement.class, ignored -> new HeadBuilder(this));
        return element(entry);
    }

    public @NonNull BodyBuilder body() {
        if (hasBody)
            throw new IllegalStateException("Document can only have one <body> element");

        hasBody = true;
        ElementEntry<BodyElement, BodyBuilder> entry = new ElementEntry<>("body", BodyElement.class, ignored -> new BodyBuilder(this));
        return element(entry);
    }
}

