package com.baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1662 {
    public static void main(String[] args) throws IOException {
        // Q라는 문자열이 K번 반복
        // K(Q)
        // K는 한자리 정수
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split("");

        boolean check = false;

        Stack<String> stack = new Stack<>();

        for(int i = 0; i<s.length; i++){
            if(!s[i].equals(")"))
                stack.push(s[i]);
            else if(s[i].equals(")")){
                check = true;
                String tmp = "";

                while(!stack.peek().equals("(")){
                    tmp+=stack.pop();
                }

                stack.pop();

                String pushTmp = "";

                int cnt = Integer.parseInt(stack.pop());

                for(int j = 0; j<cnt; j++){
                    pushTmp += tmp;
                }
                while(!stack.peek().equals("(")){
                    pushTmp+= stack.pop();
                    if(stack.isEmpty())
                        break;
                }

                stack.push(pushTmp);
            }
        }
        if(check == false) System.out.println(s.length);
        else
            System.out.println(stack.pop().length());
    }
}
