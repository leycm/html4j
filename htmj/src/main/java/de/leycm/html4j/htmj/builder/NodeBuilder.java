package de.leycm.html4j.htmj.builder;

import de.leycm.html4j.htmj.html.Node;
import lombok.NonNull;

public interface NodeBuilder<P, E extends Node> {

    @NonNull P close();

    @NonNull E build();

}
