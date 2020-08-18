package com.chapter4.adapter;

public class TestCar {
    public static void main(String[] args) {
        Car car = new Car();
        car.setName("Adui");
        car.setSpeed(60);
        System.out.println(car );
        GPSCar gpsCar = new GPSCar();
        gpsCar.setName("Audi");
        gpsCar.setSpeed(60);
        System.out.println(gpsCar );
    }
}
