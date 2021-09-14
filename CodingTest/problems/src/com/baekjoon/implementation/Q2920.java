package com.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q2920 {
    public static void main(String[] arsgs) throws IOException {
        // Stack이랑 Queue에 모두 넣어서 비교한다.
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = bf.readLine().split(" ");

        System.out.println(result(nums));
    }

    static String result(String[] nums){
        Queue<Integer> queue = new LinkedList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 1; i<9; i++){
            queue.add(i);
            stack.add(i);
        }

        for(int i = 0; i<9; i++){
            if(!queue.isEmpty()){
                if(queue.poll() == Integer.parseInt(nums[i])){
                    continue;
                }
                else
                    break;
            }
            else
                return "ascending";
        }

        for(int i = 0; i<9; i++){
            if(!stack.isEmpty()){
                if(stack.pop()== Integer.parseInt(nums[i])){
                    continue;
                }
                else
                    break;
            }
            else
                return "descending";
        }

        return "mixed";
    }
}
