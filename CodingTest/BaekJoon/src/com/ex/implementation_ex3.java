package com.ex;

import java.util.Scanner;

public class implementation_ex3 {
    public static void main(String[] args){
        int[] dx = {1,-1,2,2,-2,-2,1,-1};
        int[] dy = {2,2,1,-1,1,-1,-2,-2};

        String[] val = {"a","b","c","d","e","f","g","h"};

        Scanner sc = new Scanner(System.in);

        String[] line = sc.nextLine().split("");

        int x = Integer.parseInt(line[1]);
        int y = 0;

        int cnt = 0;

        for(int i = 0; i<val.length; i++){
            if(line[0].equals(val[i])){
                y = i+1;
            }
        }

        for(int i = 0; i<8; i++){
            int change_x = x;
            int change_y = y;

            change_x = x + dx[i];
            change_y = y + dy[i];

            if(change_x<1 || change_y <1 || change_x>8 || change_y>8){
                continue;
            }
            else{
                cnt +=1;
            }
        }

        System.out.println(cnt);
    }
}
