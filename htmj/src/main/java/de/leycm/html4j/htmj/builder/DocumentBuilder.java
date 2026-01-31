package de.leycm.html4j.htmj.builder;

import de.leycm.html4j.htmj.Document;

import lombok.NonNull;

public final class DocumentBuilder implements NodeBuilder<Document, Document> {

    private final Document document;
    private RootBuilder rootBuilder;

    public DocumentBuilder(@NonNull Document document) {
        this.document = document;
    }

    public @NonNull RootBuilder html() {
        if (rootBuilder != null)
            throw new IllegalStateException("Document already has an <html> element");

        rootBuilder = new RootBuilder(this);
        return rootBuilder;
    }

    @Override
    public @NonNull Document close() {
        return build();
    }

    public @NonNull Document build() {
        if (rootBuilder == null)
            throw new IllegalStateException("Document must contain an <html> element");

        document.setHtml(rootBuilder.build());
        return document;
    }
}
