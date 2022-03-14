package com.fc.entity;

public class Person {
    private String name;
    private String gender;
    private Car car;

    public Person(String name, String gender, Car car) {
        this.name = name;
        this.gender = gender;
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", car=" + car +
                '}';
    }
}
