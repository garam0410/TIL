package main.java;

public interface Vehicle {
    void drive();

    default void reverse() {

    }

    default void fly(){
        System.out.println("Fly");
    }
}
