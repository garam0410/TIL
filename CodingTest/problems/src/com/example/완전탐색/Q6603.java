package com.example.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Q6603 {

    static ArrayList<int[]> arrayList = new ArrayList<>();
    static int[] nums, temp;
    static boolean[] check;
    static int k;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] val;
        String s = "";
        // 0이 될때까지 값 받아오기
        do {
            val = bf.readLine().split(" ");

            if(val[0].equals("0")) break;

            temp = new int[val.length];

            for(int i = 0; i<val.length ;i++){
                temp[i] = Integer.parseInt(val[i]);
            }

            arrayList.add(temp);

        }while(true);

        // 받아온 값 불러오기
        for(int i = 0; i<arrayList.size(); i++){
            sb = new StringBuilder();
            int[] getArr = arrayList.get(i);

            k = getArr[0]; // 숫자 갯수
            nums = new int[k]; // 숫자 모음
            check = new boolean[k];

            for(int j = 1; j<k+1; j++){
                nums[j-1] = getArr[j];
            }

            rec_func(0,0,"");

            System.out.println(sb.toString());
        }
    }

    static void rec_func(int cnt, int idx, String value){
        if(cnt == 6){
            sb.append(value + "\n");
        }else{
            for(int i = idx; i<k; i++){
                if(check[i] == false){
                    check[i] = true;
                    rec_func(cnt+1, i+1, value + nums[i] + " ");
                    check[i] = false;
                }
            }
        }
    }
}
