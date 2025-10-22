package de.leycm.html4j.attr;

import de.leycm.html4j.dom.Attribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

/**
 * Immutable record implementation of the HTML {@code alt} attribute for image accessibility.
 *
 * <p>The {@code AltAttribute} provides alternative text descriptions for images, which is essential for:
 * <ul>
 *   <li>Screen reader users</li>
 *   <li>SEO optimization</li>
 *   <li>When images fail to load</li>
 *   <li>Low-bandwidth environments</li>
 * </ul>
 *
 * <h3>Usage Example:</h3>
 * <pre>{@code
 * AltAttribute altText = new AltAttribute("A red apple on a wooden table");
 *
 * // Or directly in HTML:
 * // <img src="apple.jpg" alt="A red apple on a wooden table">
 * }</pre>
 *
 * <h3>Best Practices:</h3>
 * <ul>
 *   <li>Keep alt text concise but descriptive</li>
 *   <li>For decorative images, use empty string: {@code new AltAttribute("")}</li>
 *   <li>Include relevant context and function</li>
 *   <li>Avoid "image of" or "picture of" prefixes</li>
 * </ul>
 *
 * @param alt the alternative text description (cannot be {@code null})
 *
 * @see ImageElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/img#alt">
 *      MDN img element documentation</a>
 * @see <a href="https://www.w3.org/WAI/tutorials/images/">
 *      W3C Web Accessibility Tutorials - Images</a>
 *
 * @author LeyCM
 * @version 1.0.1
 * @since 1.0.1
 */
public record AltAttribute(@NonNull String alt)
        implements Attribute {

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "alt";
    }

    @Override
    @Contract(pure = true)
    public @NonNull String value() {
        return alt;
    }

    /**
     * Escapes HTML special characters in the alt text.
     *
     * @param text the text to escape
     * @return HTML-escaped text
     */
    private @NonNull String escapeHtml(@NonNull String text) {
        return text.replace("&", "&amp;")
                .replace("\"", "&quot;")
                .replace("<", "&lt;")
                .replace(">", "&gt;");
    }
}