package club.cheapok.server;

import club.cheapok.handler.ExecutorServiceHandler;
import club.cheapok.handler.IOExceptionConverterHandler;
import club.cheapok.handler.PrintingHandler;
import club.cheapok.handler.TransmogrifyHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;

public class MultiThreadedServerV5 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8585);
        ExecutorServiceHandler handler2 = new ExecutorServiceHandler<>(
                        new PrintingHandler(
                                new TransmogrifyHandler()), Executors.newCachedThreadPool(), ((t, e) -> {
            System.out.println("Thread " + t + " has exception: " + e);
        })
        );

        while (true) {
            Socket socket = serverSocket.accept();
            handler2.handle(socket);
        }
    }

}
