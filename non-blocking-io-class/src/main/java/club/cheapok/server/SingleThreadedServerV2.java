package club.cheapok.server;

import club.cheapok.handler.TransmogrifyHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadedServerV2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8585);
        while (true) {
            Socket socket = serverSocket.accept();
            handle(socket);
        }
    }

    private static void handle(final Socket socket) throws IOException {
        System.out.println("Connected to the socket " + socket);
        try {
            new TransmogrifyHandler().handle(socket);
        } finally {
            System.out.println("Disconnected from " + socket);
        }
    }

}
