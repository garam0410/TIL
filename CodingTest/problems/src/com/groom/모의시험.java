package com.groom;

import java.util.ArrayList;
import java.util.Collections;

public class 모의시험 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int cnt = 0;
    static int block = 0;
    static ArrayList<Integer> arr = new ArrayList<>();

    static int sizeOfMatrix;
    static int[][] matrix;

    public static void main(String[] args){
        solution(6,new int[][]{{0,1,1,0,0,0},{0,1,1,0,1,1},{0,0,0,0,1,1},{0,0,0,0,1,1},{1,1,0,0,1,0},{1,1,1,0,0,0}});
    }

    private static void solution(int size, int[][] mat){
        sizeOfMatrix = size;
        matrix = mat;

        for(int i = 0; i<sizeOfMatrix; i++){
            for(int j = 0; j<sizeOfMatrix; j++){
                if(matrix[i][j] == 1){
                    cnt++;
                    rec_func(i,j);
                    arr.add(block);
                    block = 0;
                }
            }
        }

        Collections.sort(arr);

        System.out.println(cnt);

        for(int i = 0; i<arr.size(); i++){
            if(i==arr.size()-1)
                System.out.print(arr.get(i));
            else
                System.out.print(arr.get(i) + " ");
        }
    }

    private static void rec_func(int x, int y){
        if(x<=-1 || y<= -1 || x>=sizeOfMatrix || y >= sizeOfMatrix)
            return;
        else{
            if(matrix[x][y]==1){
                matrix[x][y] = 0;
                block++;
            }else{
                return;
            }

            for(int i = 0; i<4; i++){
                int cx = x + dx[i];
                int cy = y + dy[i];

                rec_func(cx, cy);
            }
        }
    }
}
