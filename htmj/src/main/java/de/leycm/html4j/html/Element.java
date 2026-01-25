package de.leycm.html4j.html;

import lombok.NonNull;

/**
 * Represents an HTML element in the document.
 *
 * <p>Elements can contain attributes.
 * This interface extends {@link Content} to inherit content-related behavior.
 *
 * @see Content
 * @see Node
 */
public interface Element extends Content {

    /**
     * Returns the tag of the HTML element.
     *
     * @return the element tag
     */
    @NonNull String tag();

}
