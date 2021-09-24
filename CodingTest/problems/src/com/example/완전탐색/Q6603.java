package com.example.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Q6603 {

    static ArrayList<int[]> arrayList = new ArrayList<>();
    static int[] nums, temp;
    static int k;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] val;

        // 0이 될때까지 값 받아오기
        while(!bf.readLine().equals("0")){
            val = bf.readLine().split(" ");

            temp = new int[val.length];

            for(int i = 0; i<val.length ;i++){
                temp[i] = Integer.parseInt(val[i]);
            }

            arrayList.add(temp);
        }

        // 받아온 값 불러오기
        for(int i = 0; i<arrayList.size(); i++){

            int[] getArr = arrayList.get(i);

            k = getArr[0];
            nums = new int[k];

            for(int j = 1; j<k+1; j++){
                nums[j-1] = getArr[j];
            }

            System.out.println(Arrays.toString(nums));
            System.out.println(k);
        }

    }
}
