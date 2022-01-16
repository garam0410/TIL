package main.java;

public class Tax implements Vehicle {

    @Override
    public void drive() {
        System.out.println("tax drive");
    }

    @Override
    public void reverse() {
        System.out.println("tax reverse");
    }
}
