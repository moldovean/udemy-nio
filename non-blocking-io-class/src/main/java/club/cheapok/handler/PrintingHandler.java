package club.cheapok.handler;

import java.io.IOException;
import java.net.Socket;

public class PrintingHandler<S> extends DecoratedHandler<S> {


    public PrintingHandler(final Handler<S> handler) {
        super(handler);
    }

    @Override
    public void handle(final S s) throws IOException {
        System.out.println("Connected to : " + s);
        try{
            super.handle(s);
        } finally {
            System.out.println("Disconnected from : "+ s);
        }
    }
}
