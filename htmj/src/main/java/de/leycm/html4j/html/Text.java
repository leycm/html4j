package de.leycm.html4j.html;

import lombok.Data;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a plain text in the HTML DOM.
 * <h6>How does it look in HTML?</h6>
 * <pre>
 * &lt;p&gt;This is a simple text.&lt;/p&gt;
 * </pre>
 * The text content is <b>"This is a simple text."</b> not including the surrounding tags.
 */
@Data
public final class Text
        implements Content {
    private final @NonNull String s;


    /**
     * Constructs a Text instance with escaped HTML characters.
     *
     * @param s the raw text content
     */
    public Text(final @NonNull String s) {
        this.s = escapeOf(s);
    }

    /**
     * Converts this test to its HTML representation with proper indentation.
     *
     * @param out    the StringBuilder to append the rendered text
     * @param indent the indentation level (number of tabs)
     * @return out for faster and better usage
     */
    @Override
    public @NotNull StringBuilder render(final @NotNull StringBuilder out, final int indent) {
        return out.append(indentOf(indent)).append(s);
    }

    /**
     * Returns the text content as a string.
     *
     * @return the text content
     */
    @Override
    public String toString() {
        return s;
    }

}
