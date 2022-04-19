package com.fc.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@Data
@Component
@ConfigurationProperties("person")
public class Father implements Person {
    private String name;
    private Integer age;
}
