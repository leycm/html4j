package de.leycm.html4j.htmj;

import de.leycm.html4j.htmj.builder.DocumentBuilder;
import de.leycm.html4j.htmj.builder.NodeBuilder;
import de.leycm.html4j.htmj.element.Containing;
import de.leycm.html4j.htmj.html.Element;
import de.leycm.html4j.htmj.html.Node;
import de.leycm.html4j.htmj.render.RenderContext;
import de.leycm.html4j.htmj.render.RenderSystem;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Document implements NodeBuilder<Document, Node>, Element {

    private Containing html;
    private final RenderSystem renderSystem;

    private Document(RenderSystem renderSystem) {
        this.renderSystem = renderSystem;
    }

    public void setHtml(@NonNull Containing html) {
        this.html = html;
    }

    @Contract(" -> new")
    public static @NonNull DocumentBuilder builder() {
        return new DocumentBuilder(new Document(RenderSystem.COMPACT));
    }

    @Contract("_ -> new")
    public static @NonNull DocumentBuilder builder(RenderSystem renderSystem) {
        return new DocumentBuilder(new Document(renderSystem));
    }

    public String render() {
        RenderContext context = renderSystem.createContext();
        render(context);
        return context.toString();
    }

    @Override
    public String toString() {
        return render();
    }

    @Override
    public @NonNull String getTag() {
        throw new UnsupportedOperationException("Document does not have a tag that can be retrieved");
    }

    @Override
    public @NonNull RenderContext render(@NonNull RenderContext context) {
        context.append("<!DOCTYPE html>");
        if (renderSystem.isPrettyPrint()) {
            context.appendLine();
        }

        html.render(context);

        if (renderSystem.isPrettyPrint()) {
            context.appendLine();
        }

        return context;
    }

    @Override
    public @NonNull Document close() {
        return this;
    }

    @Override
    public @NonNull Node build() {
        return this;
    }
}
