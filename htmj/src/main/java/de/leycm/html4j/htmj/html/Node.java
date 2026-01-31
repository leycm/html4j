package de.leycm.html4j.htmj.html;

import lombok.NonNull;

public interface Node extends Renderable,
        Comparable<Node> {

    @Override
    default int compareTo(@NonNull Node o) {
        return this.toString().compareTo(o.toString());
    }

}
