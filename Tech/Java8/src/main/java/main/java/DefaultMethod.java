package main.java;

public class DefaultMethod {
    public static void main(String[] args){
        Bus bus = new Bus();
        Tax tax = new Tax();
        HorseCar horseCar = new HorseCar();

        bus.drive();
        tax.drive();
        horseCar.drive();

        bus.reverse();
        tax.reverse();

        bus.fly();
        tax.fly();
        horseCar.fly();
    }
}