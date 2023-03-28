package com.gm.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketC {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",8181);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            new Thread(new Writer(outputStream)).start();
            new Thread(new Reader(inputStream)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
