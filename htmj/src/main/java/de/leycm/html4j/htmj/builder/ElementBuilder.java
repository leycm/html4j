package de.leycm.html4j.htmj.builder;

import de.leycm.html4j.htmj.element.Containing;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;

import java.util.function.Supplier;

public class ElementBuilder<
        P extends NodeBuilder<?, ?>,
        E extends Containing
        > extends TreeBuilder<ElementBuilder<P, E>, P, E> {

    @Contract("_, _ -> new")
    public static <P extends NodeBuilder<?, ?>, E extends Containing> @NonNull ElementBuilder<P, E> create(
            final @NonNull P parent,
            final @NonNull Supplier<E> constructor) {
        return new ElementBuilder<>(parent, constructor);
    }

    protected final Supplier<E> constructor;

    protected ElementBuilder(final @NonNull P parent,
                             final @NonNull Supplier<E> constructor
    ) {
        super(parent);
        this.constructor = constructor;
    }

    @Override
    protected @NonNull E constructElement() {
        return constructor.get();
    }
}
