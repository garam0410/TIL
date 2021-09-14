package com.ex;

public class greedy_ex1 {
    public static void main(String[] args){
        int n = 1260;
        int cnt = 0;
        int[] coin = {500,100,50,10};

        for(int i = 0; i<coin.length; i++){
            cnt += n / coin[i];
            n %= coin[i];
        }

        System.out.println(cnt);
    }
}
