package de.leycm.html4j.attr;

import lombok.NonNull;

public class IdAttribute extends HtmlAttribute<String> {

    public IdAttribute(@NonNull String value) {
        super("id", value);
    }

}
