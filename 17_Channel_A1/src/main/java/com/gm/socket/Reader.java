package com.gm.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class Reader implements Runnable {
    private InputStream inputStream;
    public Reader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(this.inputStream);
            while (true){
                System.out.println("接收："+objectInputStream.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
