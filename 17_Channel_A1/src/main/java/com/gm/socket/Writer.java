package com.gm.socket;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Writer implements Runnable {
    private OutputStream outputStream;
    public Writer(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(this.outputStream);
            while (true){
                JSONObject json = new JSONObject();
                json.put("消息", scanner.next());
                //发消息
                objectOutputStream.writeObject(json);
                //刷新流
                objectOutputStream.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
