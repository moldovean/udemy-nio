package club.cheapok.handler;

public class ThreadedHandler extends IOExceptionConverterHandler {

    public ThreadedHandler(final Handler other) {
        super(other);
    }

    @Override
    public void handle(final Object socket) {
        new Thread(()->super.handle(socket)).start();

    }
}
