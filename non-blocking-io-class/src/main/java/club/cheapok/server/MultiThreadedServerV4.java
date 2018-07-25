package club.cheapok.server;

import club.cheapok.handler.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedServerV4 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8585);
        IOExceptionConverterHandler handler2 = new ThreadedHandler(
                    new IOExceptionConverterHandler(
                        new PrintingHandler(
                                new TransmogrifyHandler())));

        while (true) {
            Socket socket = serverSocket.accept();
            handler2.handle(socket);
        }
    }

}
