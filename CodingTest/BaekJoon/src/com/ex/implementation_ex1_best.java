package com.ex;

public class implementation_ex1_best {
    public static void main(String[] args){
        int N = 5;
        String[] locations = {"R","R","R","U","D","D"};
        int x = 1;
        int y = 1;

        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        String[] moveTypes = {"L","R","U","D"};

        for(int i = 0; i<locations.length; i++){
            String plan = locations[i];

            int nx = -1, ny = -1;

            for(int j = 0; j<4; j++){
                if(plan.equals(moveTypes[j])){
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }

            if(nx < 1 || ny < 1 || nx > N || ny > N) continue;

            x = nx;
            y = ny;
        }

        System.out.println(x + " " + y);
    }
}
