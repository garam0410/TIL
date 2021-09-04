package com.ex;

public class greedy_ex3 {
    public static void main(String[] args){
        String s = "567";
        int answer = 0;

        String[] nums = s.split("");

        for(int i = 0; i<nums.length; i++){
            int val = Integer.parseInt(nums[i]);
            if(answer <= 1 || val <= 1)
                answer += val;
            else if(answer >= 2 && val >=2)
                answer *= val;
        }

        System.out.println(answer);
    }
}
