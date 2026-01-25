package de.leycm.html4j.html;

import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;


public final class Closing implements Element {
    private final @NonNull String tag;

    public Closing(@NonNull String tag) {
        this.tag = tag;
    }


    @Override
    public @NotNull StringBuilder render(@NonNull StringBuilder out, int indent) {
        return out.append(indentOf(indent)).append("<").append(tag).append(">");
    }

    @Override
    public @NonNull String tag() {
        return tag;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Closing) obj;
        return Objects.equals(this.tag, that.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tag);
    }

    @Override
    public String toString() {
        return "Closing[" +
                "tag=" + tag + ']';
    }

}
