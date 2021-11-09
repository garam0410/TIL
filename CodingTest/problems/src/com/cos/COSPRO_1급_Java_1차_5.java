package com.cos;

import java.util.Arrays;

public class COSPRO_1급_Java_1차_5 {

    static int[][] matrix;
    static int maxValue;
    static int x = 0;
    static int y = 0;
    static int n;
    static String mode = "Right";

    static int solution(int n) {
        int answer = 0;
        maxValue = n * n;

        x = 0;
        y = 0;
        mode = "Right";

        matrix = new int[n][n];

        for(int i = 1; i<=maxValue; i++){
            matrix[x][y] = i;
            check(n);
        }

        for(int i = 0; i<matrix.length; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }

        for(int i = 0; i<n; i++){
            answer += matrix[i][i];
        }

        return answer;
    }

    static void check(int n){
        if(mode.equals("Right") && (y+1 >= n || matrix[x][y+1] != 0)){
            mode = "Down";
        }
        else if(mode.equals("Down") && (x+1 >= n || matrix[x+1][y] != 0)){
            mode = "Left";
        }
        else if(mode.equals("Left") && (y-1 <= -1 || matrix[x][y-1] != 0)){
            mode = "Up";
        }
        else if(mode.equals("Up") && (x-1 <= -1 || matrix[x-1][y] != 0)){
            mode = "Right";
        }

        if(mode.equals("Right")){
            y++;
        }
        else if(mode.equals("Down")){
            x++;
        }
        else if(mode.equals("Left")){
            y--;
        }
        else if(mode.equals("Up")){
            x--;
        }
    }

    public static void main(String[] args) {
        int n2 = 4;
        int ret2 = solution(n2);
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}