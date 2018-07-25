package club.cheapok.handler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import static club.cheapok.utilities.Util.transmogrify;

public class TransmogrifyHandler implements Handler<Socket> {

    @Override
    public void handle(final Socket socket) throws IOException {
        try (Socket s = socket;
             InputStream inputStream = s.getInputStream();
             OutputStream outputStream = s.getOutputStream()) {

            int data;
            while ((data = inputStream.read()) != -1) {
                if (data == '%') {
                    throw new IOException("Oooopsie");
                }
                outputStream.write(transmogrify(data));
                System.out.print((char) data);
            }
        }
    }
}
