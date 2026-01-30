package de.leycm.html4j.htmj.html;

import org.jetbrains.annotations.NotNull;

public interface Node extends Renderable,
        Comparable<Node> {

    @Override
    default int compareTo(@NotNull Node o) {
        return this.toString().compareTo(o.toString());
    }

}
