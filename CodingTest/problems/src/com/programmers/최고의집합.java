package com.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class 최고의집합 {
    public static void main(String[] args){
        System.out.println(Arrays.toString(new Solution().solution(2,9)));
    }
}

class Solution {
    static int n, s, mod;
    static int[] answer;
    static int max = Integer.MIN_VALUE;

    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static Stack<Integer> stack = new Stack<>();

    public int[] solution(int n, int s) {

        this.n = n;
        this.s = s;

        if(s%n > 0) mod = s/n+1;
        else mod = s/n;

        rec_func(0, 0, 0);

        if(pq.size() == 0)
            return new int[]{-1};
        else{
            answer = new int[n];

            for(int i = 0; i<n; i++){
                answer[i] = pq.poll();
            }

            return answer;
        }
    }

    static boolean rec_func(int cnt, int sumValue, int xValue){
        if(cnt == n){
            if(sumValue == s){
                if(xValue > max){
                    pq.clear();
                    max = xValue;
                    Stack<Integer> tmp = (Stack<Integer>) stack.clone();

                    while(!tmp.isEmpty())
                        pq.add(tmp.pop());

                    return true;
                }
            }else return false;
        }
        else{

            for(int i = mod; i>0; i--){
                stack.push(i);

                if(xValue == 0)
                    if(rec_func(cnt+1, sumValue+i, i)) return true;
                else
                    if(rec_func(cnt+1, sumValue+i, xValue*i)) return true;

                stack.pop();
            }
        }
        return false;
    }
}