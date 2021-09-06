package com.ex;

public class implementation_ex1 {
    public static void main(String[] args){
        int N = 5;
        String[] locations = {"R","R","R","U","D","D"};

        int x = 1, y = 1;
        int change_x = 1, change_y = 1;

        for(int i = 0; i<locations.length; i++){

            if(locations[i].equals("L")){
                change_y -= 1;
            }
            else if(locations[i].equals("R")){
                change_y += 1;
            }
            else if(locations[i].equals("U")){
                change_x -= 1;
            }
            else if(locations[i].equals("D")){
                change_x += 1;
            }

            if(change_x < 1 || change_y < 1 || change_x>N || change_y >N){
                change_x = x;
                change_y = y;
            }else{
                x = change_x;
                y = change_y;
            }
        }

        System.out.println(x + " " + y);
    }
}
