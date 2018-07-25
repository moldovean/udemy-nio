package club.cheapok.server;

import club.cheapok.handler.Handler;
import club.cheapok.handler.PrintingHandler;
import club.cheapok.handler.TransmogrifyHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadedServerV3 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8585);
        Handler handler = new PrintingHandler(new TransmogrifyHandler());
        while (true) {
            Socket socket = serverSocket.accept();
            handler.handle(socket);
        }
    }

}
