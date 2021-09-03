package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class RemoveDuplicatesFromSortedArray {
    static int[] numbers = {0,1,1,2,2,2,3,4,4};
    public static void main(String[] args){

        System.out.println(new Solution().removeDuplicates(numbers));
        System.out.println(Arrays.toString(numbers));
    }

    static class Solution {
        public int removeDuplicates(int[] nums) {
            int answer = 0;

            HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();

            for(int i = 0; i<nums.length; i++)
                hash.put(nums[i],i);

            answer = hash.size();

            int i = 0;

            for(int num : hash.keySet()){
                numbers[i] = num;
                i++;
            }
            for(int j = i; j<nums.length; j++){
                numbers[j] = 100;
            }
            Arrays.sort(numbers);

            return answer;
        }
    }
}
