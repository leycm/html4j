package de.leycm.html4j.htmj.html;

import lombok.NonNull;

public interface Element extends Node {

    @NonNull String getTag();

}