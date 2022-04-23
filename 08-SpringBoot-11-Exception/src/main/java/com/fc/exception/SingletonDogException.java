package com.fc.exception;

// 自定义单身狗异常
public class SingletonDogException extends Exception {
    public SingletonDogException() {
        super();
    }

    public SingletonDogException(String message) {
        super(message);
    }
}
