package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MedianofTwoSortedArrays {
    public static void main(String[] args){
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1,1}, new int[]{1,2}));
    }

    static class Solution{
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            double answer = 0.0;

            ArrayList<Integer> map = new ArrayList<Integer>();

            for(int i = 0; i<nums1.length; i++)
                map.add(nums1[i]);

            for(int i = 0; i<nums2.length; i++)
                map.add(nums2[i]);

            System.out.println(map.size());

            int[] list = new int[map.size()];

            for(int i = 0; i<map.size(); i++){
                list[i] = map.get(i);
            }

            Arrays.sort(list);
            System.out.println(Arrays.toString(list));

            if(list.length % 2 == 0){
                answer = (list[list.length/2] + list[list.length/2-1]) / 2.0;
            }else{
                answer = list[list.length/2];
            }

            return answer;
        }
    }

}
