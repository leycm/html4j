package de.leycm.html4j.css;

import de.leycm.html4j.dom.Style;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

import java.awt.*;

public record ColorStyle(@NonNull Color color)
        implements Style {

    @Override
    @Contract(pure = true)
    public @NonNull String name() {
        return "color";
    }

    @Override
    public @NonNull String value() {
        String buf = Integer.toHexString(color.getRGB());
        return "#" + buf.substring(buf.length()-6);
    }

}
