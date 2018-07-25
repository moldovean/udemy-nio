package club.cheapok.server;

import club.cheapok.handler.Handler;
import club.cheapok.handler.IOExceptionConverterHandler;
import club.cheapok.handler.PrintingHandler;
import club.cheapok.handler.TransmogrifyHandler;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedServerV3 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8585);
        Handler handler = new PrintingHandler(new TransmogrifyHandler());
        IOExceptionConverterHandler handler2 = new IOExceptionConverterHandler(handler);
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(() -> handler2.handle(socket)).start();
        }
    }

}
