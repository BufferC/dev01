package com.fc.exception;

import org.springframework.stereotype.Component;

//异常
@Component
public class MyException extends Exception{
    public MyException(){
        super();
    }
    public MyException(String message){
        super(message);
    }
}
