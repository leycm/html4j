package de.leycm.html4j.util;

import de.leycm.html4j.dom.Attribute;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

public interface BooleanAttribute extends Attribute {

    /**
     * Returns the attribute value as boolean.
     *
     * @return the attribute value
     */
    boolean is();

    @Override
    @Contract(pure = true)
    default @NonNull String value() {
        return is() ? "true" : "false";
    }

}
