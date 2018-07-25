package club.cheapok.handler;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.Socket;

public class IOExceptionConverterHandler<S> extends DecoratedHandler<S> {

    public IOExceptionConverterHandler(final Handler<S> handler) {
        super(handler);
    }

    @Override
    public void handle(final S socket) {
        try {
            super.handle(socket);
        } catch (IOException e) {
            //throw new UncheckedIOException(e);
        }
    }
}
