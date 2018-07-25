package club.cheapok.server;

import club.cheapok.utilities.Util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadedServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8585);
        while (true) {
            Socket socket = serverSocket.accept();
            handle(socket);
        }
    }

    private static void handle(final Socket socket) throws IOException {
        System.out.println("Connected to the socket " + socket);

        try (Socket s = socket;
             InputStream inputStream = s.getInputStream();
             OutputStream outputStream = s.getOutputStream()) {

            int data;
            while ((data = inputStream.read()) != -1) {
                outputStream.write(Util.transmogrify(data));
                System.out.print((char) data);
            }
        } finally {
            System.out.println("Disconnected from " + socket);
        }
    }

}
