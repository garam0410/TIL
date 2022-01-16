package main.java;

public class LambdaExpression {
    public static void main(String[] args){
        noLambdaThread();
        lambdaThread();

    }

    public static void noLambdaThread(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("new thread");
            }
        });

        thread.start();
    }

    public static void lambdaThread(){
        Thread thread = new Thread(() -> System.out.println("new thread (lambda)"));

        thread.start();
    }
}
