package de.leycm.html4j.htmj;

import de.leycm.html4j.htmj.element.Containing;
import de.leycm.html4j.htmj.element.SelfClosing;
import de.leycm.html4j.htmj.element.TextContent;
import de.leycm.html4j.htmj.html.Node;
import de.leycm.html4j.htmj.render.RenderSystem;

public class Document {
    private final Containing html;
    private final RenderSystem renderSystem;

    private Document(Containing html, RenderSystem renderSystem) {
        this.html = html;
        this.renderSystem = renderSystem;
    }

    public static DocumentBuilder html() {
        return new DocumentBuilder();
    }

    public String render() {
        return "<!DOCTYPE html>\n" + 
               html.render(renderSystem.createContext(), 0).toString();
    }

    @Override
    public String toString() {
        return render();
    }

    public static class DocumentBuilder {
        private Containing html;
        private RenderSystem renderSystem = RenderSystem.PRETTY;

        public HeadBuilder head(String id, String classes) {
            Containing head = new Containing("head");
            this.html = new Containing("html", head);
            return new HeadBuilder(this, head, id, classes);
        }

        public BodyBuilder body() {
            Containing body = new Containing("body");
            this.html = new Containing("html", body);
            return new BodyBuilder(this, body);
        }

        public Document build() {
            if (html == null) {
                throw new IllegalStateException("Document must have at least a head or body");
            }
            return new Document(html, renderSystem);
        }
    }

    public static class HeadBuilder {
        private final DocumentBuilder parent;
        private final Containing head;

        private HeadBuilder(DocumentBuilder parent, Containing head, String id, String classes) {
            this.parent = parent;
            this.head = head;
            // todo: Add id and classes attributes
        }

        public HeadBuilder title(String title) {
            Containing titleElement = new Containing("title");
            titleElement.add(new TextContent(title, true));
            head.add(titleElement);
            return this;
        }

        public HeadBuilder meta() {
            head.add(new SelfClosing("meta"));
            return this;
        }

        public DocumentBuilder close() {
            return parent;
        }
    }

    public static class BodyBuilder {
        private final DocumentBuilder parent;
        private Containing currentElement;
        private final Containing body;

        private BodyBuilder(DocumentBuilder parent, Containing body) {
            this.parent = parent;
            this.body = body;
            this.currentElement = body;
        }

        public BodyBuilder div(String id, String classes) {
            Containing div = new Containing("div");
            // todo: Add id and classes attributes
            currentElement.add(div);
            currentElement = div;
            return this;
        }

        public BodyBuilder div() {
            return div(null, null);
        }

        public BodyBuilder p() {
            Containing p = new Containing("p");
            currentElement.add(p);
            currentElement = p;
            return this;
        }

        public BodyBuilder paragraphOf(String text) {
            return p().escaped(text).close();
        }

        public BodyBuilder escaped(String text) {
            if (text != null) {
                currentElement.add(new TextContent(text, true));
            }
            return this;
        }

        public BodyBuilder close() {
            if (currentElement != body) {
                currentElement = (Containing) currentElement.getParent();
            }
            return this;
        }

        public DocumentBuilder closeBody() {
            return parent;
        }
    }
}
