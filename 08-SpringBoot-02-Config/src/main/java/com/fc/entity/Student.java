package com.fc.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "student")
public class Student {
    private String name;
    private Integer age;
    private String gender;
    private Date birthday;
    private Boolean married;
    private String[] hobby;
    private List<String> food;
    private Map<String, Object> score;
    private Car car;
}
