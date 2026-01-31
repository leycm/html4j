package de.leycm.html4j.htmj.content;

import de.leycm.html4j.htmj.html.Content;

import lombok.Getter;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

@Getter
public abstract class StringContent implements Content {
    protected final @NonNull String content;

    public StringContent(final @NonNull String content) {
        this.content = content;
    }

    @Override
    public String content() {
        return content;
    }

    @Override
    public boolean equals(final @Nullable Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Content c)) return false;
        return equals(c);
    }
}
