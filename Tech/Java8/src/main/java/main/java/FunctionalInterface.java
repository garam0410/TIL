package main.java;

public class FunctionalInterface{
    public static void main(String[] args){
        noFuncInterface();
        funcInterface();
    }

    public static void noFuncInterface(){
        Car car = new Car() {
            @Override
            public String drive(int driveLevel) {
                return driveLevel == 0 ? "" : "자동차가 " + driveLevel + "의 속도로 이동 중.";
            }
        };

        System.out.println(car.drive(10));
    }

    public static void funcInterface(){
        Car car = (i) -> i == 0 ? "" : "자동차가 " + i + "의 속도로 이동 중.";
        System.out.println(car.drive(0));
    }
}
