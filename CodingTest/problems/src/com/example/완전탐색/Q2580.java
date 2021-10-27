package com.example.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q2580 {
    static int[][] board = new int[9][9];
    static ArrayList<int[]> emptyList = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        // 값 넣기
        for(int i = 0; i<9; i++){
            String[] vals = bf.readLine().split(" ");

            for(int j = 0; j<9; j++){
                board[i][j] = Integer.parseInt(vals[j]);

                if(board[i][j] == 0){
                    int[] tmp = new int[2];
                    tmp[0] = i;
                    tmp[1] = j;
                    emptyList.add(tmp);
                }
            }
        }

        // 로직 수행
        rec_func(0);

        // 출력
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++)
                sb.append(board[i][j] + " ");
            sb.delete(sb.length()-1, sb.length());
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static boolean rec_func(int idx){
        if(idx == emptyList.size()){
            return true;
        }else{
            int x = emptyList.get(idx)[0];
            int y = emptyList.get(idx)[1];

            for(int j = 1; j<10; j++){
                if(check(x,y,j)){
                    board[x][y] = j;

                    if(rec_func(idx+1)) return true;
                    else board[x][y] = 0;
                }
            }
        }
        return false;
    }

    static boolean check(int x, int y, int value){
        //가로 검사
        for(int i = 0; i<9; i++){
            if(board[x][i] == value) return false;
        }

        //세로 검사
        for(int i = 0; i<9; i++){
            if(board[i][y] == value) return false;
        }

        //사각형 검사
        x = (x / 3) * 3;
        y = (y / 3) * 3;

        for(int i = x; i<x+3; i++){
            for(int j = y; j<y+3; j++){
                if(board[i][j] == value) return false;
            }
        }

        return true;
    }
}
