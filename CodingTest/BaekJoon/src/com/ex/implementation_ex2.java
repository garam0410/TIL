package com.ex;

public class implementation_ex2 {
    public static void main(String[] args){
        int N = 5;

        int hour = 0;
        int minute = 0;
        int sec = -1;

        int cnt = 0;

        for(int i = 0; i<N+1; i++){
            for(int j = 0; j<60;j++){
                for(int k =0; k<60; k++){
                    String tmp = String.valueOf(i) + String.valueOf(j) + String.valueOf(k);
                    System.out.println(i +":" + j+":"+k);
                    if(tmp.contains("3")) {
                        cnt += 1;
                        System.out.println(cnt);
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
