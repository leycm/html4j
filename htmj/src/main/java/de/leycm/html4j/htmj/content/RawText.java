package de.leycm.html4j.htmj.content;

import lombok.NonNull;

public final class RawText extends StringContent {
    public RawText(final @NonNull String content) {
        super(content);
    }
}
