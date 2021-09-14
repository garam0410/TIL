package com.example.완전탐색;

import java.util.Scanner;

//백트래킹
public class Q9663 {
    static int N, ans; // ans : 가능한 경우의 수를 셀 변수
    static int[] col; // i번 행의 queen은 col[i]번 열에 놓았다는 기록

    static void rec_func(int row){
        if(row == N+1){
            ans++;
        }else{
            for(int c = 1; c<=N; c++){
                boolean possible = true;
                //valid check(row,c)
                for(int i = 1;i<=row-1; i++){
                    //(i, col[i])
                    if(attackable(row,c,i,col[i])){
                        possible = false;
                        break;
                    }
                }
                if(possible){
                    col[row] = c;
                    rec_func(row+1);
                    col[row] = 0;
                }
            }
        }
    }

    static boolean validity_check(){
        for(int i = 1; i<=N; i++){
            //(i,col[i])
            for(int j = 1; j<i ;j++){
                //(j,col[j])
                if(attackable(i,col[i],j,col[j])){
                    return false;
                }
            }
        }
        return true;
    }

    static boolean attackable(int r1, int c1, int r2, int c2){
        if(c1 == c2) return true;
        if(r1 - c1 == r2 - c2) return true;
        if(r1 + c1 == r2 + c2) return true;
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        col = new int[N+1];
        rec_func(1);
        System.out.println(ans);
    }
}
