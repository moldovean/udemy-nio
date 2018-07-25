package club.cheapok.handler;

import java.io.IOException;

// Decorator pattern
public interface Handler<S> {
    void handle(S s) throws IOException;
}
