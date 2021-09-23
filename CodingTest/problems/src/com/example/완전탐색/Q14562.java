package com.example.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q14562 {
    static ArrayList<Integer> answer;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(bf.readLine());

        ArrayList<int[]> arr = new ArrayList<>();
        answer = new ArrayList<>();

        for(int i = 0; i<C; i++){
            String[] tmp = bf.readLine().split(" ");

            int[] temp = new int[2];
            temp[0] = Integer.parseInt(tmp[0]);
            temp[1] = Integer.parseInt(tmp[1]);

            arr.add(temp);
        }

        for(int i = 0; i<arr.size(); i++){
            result = Integer.MAX_VALUE;
            int[] tmp = arr.get(i);
            rec_func(tmp[0], tmp[1], 0);
            System.out.println(result);
        }
    }
    // A점수, B점수, 발차기 횟수
    static boolean rec_func(int A, int B, int cnt) {
        if(A==B){
            result = Math.min(result, cnt);
            return true;
        }
        if(A>B)
            return false;

            rec_func(A+1,B,cnt+1);
            rec_func(A+A,B+3,cnt+1);
        return false;
    }
}
