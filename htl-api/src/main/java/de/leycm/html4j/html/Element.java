package de.leycm.html4j.html;

import de.leycm.html4j.dom.Node;
import lombok.NonNull;

public class Element implements Node {

    // Default element auch div etz als classen machen

    @Override
    public @NonNull String toHtml(int indent) {
        return "";
    }

}
