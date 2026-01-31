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

    public void setHtml(@NotNull Containing html) {
        this.html = html;
    }

    @Contract(" -> new")
    public static @NotNull DocumentBuilder builder() {
        return new DocumentBuilder(new Document(RenderSystem.COMPACT));
    }

    @Contract("_ -> new")
    public static @NotNull DocumentBuilder builder(RenderSystem renderSystem) {
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
        return "document"; // todo: may throw UnsupportedOperationException
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
    public @NotNull Document close() {
        return this;
    }

    @Override
    public @NotNull Node build() {
        return this;
    }
}
