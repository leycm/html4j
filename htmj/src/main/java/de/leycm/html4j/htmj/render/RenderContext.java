package de.leycm.html4j.htmj.render;

import de.leycm.html4j.htmj.html.Node;
import lombok.Getter;
import lombok.NonNull;

import java.io.Serializable;

public class RenderContext implements Appendable, Serializable, Comparable<RenderContext>, CharSequence {
    private final StringBuilder builder;
    private final String lineEnding;
    @Getter
    private final RenderSystem system;
    private int currentIndent = 0;

    public RenderContext() {
        this(new StringBuilder(), "\n", RenderSystem.builder().build());
    }

    public RenderContext(final int indent) {
        this(new StringBuilder(), "\n", RenderSystem.builder().build());
        this.currentIndent = indent;
    }

    public RenderContext(final @NonNull StringBuilder builder) {
        this(builder, "\n", RenderSystem.builder().build());
    }

    public RenderContext(final @NonNull StringBuilder builder,
                        final @NonNull String lineEnding,
                        final @NonNull RenderSystem system) {
        this.builder = builder;
        this.lineEnding = lineEnding;
        this.system = system;
    }

    public RenderContext indent() {
        currentIndent++;
        return this;
    }

    public RenderContext unindent() {
        if (currentIndent > 0) {
            currentIndent--;
        }
        return this;
    }

    public RenderContext appendIndent() {
        if (system.isPrettyPrint()) {
            builder.append(system.indentOf(currentIndent));
        }
        return this;
    }

    public RenderContext appendLine() {
        if (system.isPrettyPrint()) {
            builder.append(lineEnding);
        }
        return this;
    }

    public RenderContext appendLine(final @NonNull CharSequence text) {
        append(text);
        return appendLine();
    }

    public RenderContext render(@NonNull Node node) {
        node.render(this);
        return this;
    }

    @Override
    public RenderContext append(CharSequence csq) {
        builder.append(csq);
        return this;
    }

    @Override
    public RenderContext append(final @NonNull CharSequence csq, final int start, final int end) {
        builder.append(csq, start, end);
        return this;
    }

    @Override
    public RenderContext append(char c) {
        builder.append(c);
        return this;
    }

    @Override
    public int length() {
        return builder.length();
    }

    @Override
    public char charAt(final int index) {
        return builder.charAt(index);
    }

    @Override
    public @NonNull CharSequence subSequence(final int start,
                                             final int end) {
        return builder.subSequence(start, end);
    }

    @Override
    public int compareTo(final @NonNull RenderContext o) {
        return builder.toString().compareTo(o.builder.toString());
    }

    @Override
    public @NonNull String toString() {
        return builder.toString();
    }

}
