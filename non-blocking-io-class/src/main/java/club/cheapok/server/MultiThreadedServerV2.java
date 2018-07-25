package club.cheapok.server;

import club.cheapok.handler.TransmogrifyHandler;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedServerV2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8585);
        while (true) {
            Socket socket = serverSocket.accept();
            handle(socket);
        }
    }

    private static void handle(final Socket socket) throws IOException {
        new Thread(() -> {
            System.out.println("Connected to the socket " + socket);
            try {
                new TransmogrifyHandler().handle(socket);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            } finally {
                System.out.println("Disconnected from " + socket);
            }
        }).start();
    }

}
