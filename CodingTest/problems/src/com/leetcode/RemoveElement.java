package com.leetcode;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args){
        System.out.println(new Solution().removeElement(new int[]{3,2,2,3},3));
        System.out.println(new Solution().removeElement(new int[]{0,1,2,2,3,0,4,2},2));
    }

    static class Solution {
        public int removeElement(int[] nums, int val) {
            int answer = 0;

            for(int i = 0; i<nums.length; i++){
                if(nums[i] == val)
                    nums[i] = 50;
                else
                    answer += 1;
            }

            Arrays.sort(nums);

            return answer;
        }
    }
}
