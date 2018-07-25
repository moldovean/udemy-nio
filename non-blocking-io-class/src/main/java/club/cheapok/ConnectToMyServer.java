package club.cheapok;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ConnectToMyServer {
    public static void main(String[] args) throws IOException {
        System.out.println("Starting... ");
        Socket socket = new Socket("localhost", 8585);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello world".getBytes());
        byte[] iaka = new byte[128];
        int data;
        while ((data = inputStream.read()) != -1) {
            System.out.print((char)data);
        }
//        inputStream.read(iaka);
//        System.out.println(new String(iaka));

        System.out.println("Done!");
    }
}
