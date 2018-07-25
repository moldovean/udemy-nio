package club.cheapok.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedServer {
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

            try (Socket s = socket;
                 InputStream inputStream = s.getInputStream();
                 OutputStream outputStream = s.getOutputStream()) {

                int data;
                while ((data = inputStream.read()) != -1) {
                    outputStream.write(transmogrify(data));
                }
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            } finally {
                System.out.println("Disconnected from " + socket);
            }
        }).start();
    }

    private static int transmogrify(final int data) {
        return Character.isLetter(data) ? data ^ ' ' : data;
    }
}
