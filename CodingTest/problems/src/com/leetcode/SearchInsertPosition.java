package com.leetcode;

public class SearchInsertPosition {
    public static void main(String[] args){
        System.out.println(new Solution().searchInsert(new int[]{1,3,4,5}, 7));
    }

    static class Solution {
        public int searchInsert(int[] nums, int target) {
            int answer = 0;

            for(int i = 0; i<nums.length; i++){
                if(nums[i]>=target){
                    answer = i;
                    break;
                }else if(i==nums.length-1){
                    answer = nums.length;
                    break;
                }
            }

            return answer;
        }
    }
}
