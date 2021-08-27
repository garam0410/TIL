package com.leetcode;

public class TwoSum {
    public static void main(String[] args){
        new Solution().twoSum(new int[]{2,7,11,13}, 9);
    }

    static class Solution{

        public int[] twoSum(int[] nums, int target){
            int[] answer = new int[2];

            for(int i = 0; i<nums.length; i++){
                for(int j = 0; j<nums.length; j++){
                    if(i==j) continue;
                    else if(nums[i] + nums[j] == target){
                        answer[0] = j;
                        answer[1] = i;
                        break;
                    }
                }
            }

            System.out.println(answer[0]+" "+ answer[1]);
            return answer;
        }

    }
}
