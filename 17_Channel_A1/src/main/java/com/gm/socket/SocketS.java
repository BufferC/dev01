package com.gm.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketS {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8181);

            Socket accept = serverSocket.accept();

            InputStream inputStream = accept.getInputStream();
            OutputStream outputStream = accept.getOutputStream();

            new Thread(new Reader(inputStream)).start();
            new Thread(new Writer(outputStream)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
