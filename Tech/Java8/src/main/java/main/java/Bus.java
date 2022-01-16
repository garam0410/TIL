package main.java;

public class Bus implements Vehicle {

    @Override
    public void drive() {
        System.out.println("bus drive");
    }

    @Override
    public void reverse() {
        System.out.println("bus reverse");
    }
}
