package com.gm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.gm.socket")
public class ChannelA1Application {

    public static void main(String[] args) {
        SpringApplication.run(ChannelA1Application.class, args);
    }

}
