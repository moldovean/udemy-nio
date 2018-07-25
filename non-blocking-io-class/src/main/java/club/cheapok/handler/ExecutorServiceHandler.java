package club.cheapok.handler;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

public class ExecutorServiceHandler<S> extends DecoratedHandler<S> {

    private final Thread.UncaughtExceptionHandler exceptionHandler;
    private ExecutorService executorService;

    public ExecutorServiceHandler(final Handler<S> handler,
                                     ExecutorService executorService,
                                     Thread.UncaughtExceptionHandler exceptionHandler) {
        super(handler);
        this.executorService = executorService;
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    public void handle(final S s) throws IOException {
        executorService.submit(new FutureTask<Object>(() -> {
                                   super.handle(s);
                                   return null;
                               }) {
                                   @Override
                                   protected void setException(final Throwable t) {
                                       exceptionHandler.uncaughtException(Thread.currentThread(), t);
                                   }
                               }
        );

    }
}
