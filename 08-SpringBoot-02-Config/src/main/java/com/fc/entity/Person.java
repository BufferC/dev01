package com.fc.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("person")
public class Person {
    private String username;
    private String password;
}
