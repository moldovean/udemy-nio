package club.cheapok.handler;

import java.io.IOException;

public abstract class DecoratedHandler<S> implements Handler<S> {
    private final Handler<S> other;

    protected DecoratedHandler(final Handler<S> other) {
        this.other = other;
    }

    @Override
    public void handle(final S s) throws IOException {
        other.handle(s);
    }
}
