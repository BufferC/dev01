package com.fc.entity;

public class Car {
    private Float speed;
    private String color;

    @Override
    public String toString() {
        return "Car{" +
                "speed=" + speed +
                ", color='" + color + '\'' +
                '}';
    }

    public Car(Float speed, String color) {
        this.speed = speed;
        this.color = color;
    }
}
