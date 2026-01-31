package de.leycm.html4j.htmj.builder;

import de.leycm.html4j.htmj.element.BodyElement;
import de.leycm.html4j.htmj.element.RootElement;
import de.leycm.html4j.htmj.registry.ElementEntry;

import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

public final class RootBuilder extends TreeBuilder<RootBuilder, DocumentBuilder, RootElement> {
    private boolean hasHead = false;
    private boolean hasBody = false;

    public RootBuilder(@NonNull DocumentBuilder parent) {
        super(parent);
    }

    @Override
    protected @NotNull RootElement constructElement() {
        return new RootElement();
    }

    public @NonNull BodyBuilder head() {
        if (hasHead) {
            throw new IllegalStateException("Document can only have one <head> element");
        }
        hasHead = true;
        // todo: change this to head builder when it is implemented
        ElementEntry<BodyElement, BodyBuilder> entry = new ElementEntry<>("head", BodyElement.class, ignored -> new BodyBuilder(this));
        return element(entry);
    }

    public @NonNull BodyBuilder body() {
        if (hasBody) {
            throw new IllegalStateException("Document can only have one <body> element");
        }
        hasBody = true;
        ElementEntry<BodyElement, BodyBuilder> entry = new ElementEntry<>("body", BodyElement.class, ignored -> new BodyBuilder(this));
        return element(entry);
    }
}

