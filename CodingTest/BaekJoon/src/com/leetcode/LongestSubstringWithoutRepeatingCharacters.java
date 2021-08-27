package com.leetcode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args){
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
    }

    static class Solution{
        static int lengthOfLongestSubstring(String s){
            int result = 0;

            HashMap<Character, Integer> map = new HashMap<Character, Integer>();

            for(int i = 0; i<s.length(); i++){
                map.put(s.charAt(i),i);
                int cnt = 0;
                for(int j = i+1; j<s.length(); j++){
                    if(map.get(s.charAt(j))==null){
                        map.put(s.charAt(j),j);
                    }
                    else
                        break;
                }

                if(result<map.size())
                    result = map.size();

                map.clear();
            }

            return result;
        }
    }

}
