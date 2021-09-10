package com.baekjoon.string;

import java.util.*;

public class Q1259{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        while(true){
            String tmp = sc.nextLine();
            if(tmp.equals("0"))
                break;
            for(int i = 0; i<tmp.length(); i++){
                stack.push(tmp.charAt(i));
            }
            int j = 0;
            boolean result = true;
            while(!stack.isEmpty()){
                char temp = stack.pop();
                if(temp != tmp.charAt(j)){
                    result = false;
                    stack.clear();
                    break;
                }
                j++;
            }
            if(result == true)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}
