package de.leycm.html4j.html;

import de.leycm.html4j.dom.Node;
import lombok.NonNull;

public record RawElement(String raw) implements Node {

    public RawElement(@NonNull String raw) {
        this.raw = raw;
    }

    @Override
    public @NonNull String toHtml(int indent) {
        return indent(indent) + raw;
    }

}
