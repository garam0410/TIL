package com.leetcode;

import java.util.*;

public class ValidParentheses {
    public static void main(String[] args){
        System.out.println(new Solution().isValid("()"));
        System.out.println(new Solution().isValid("()[]{}"));
        System.out.println(new Solution().isValid("(]"));
        System.out.println(new Solution().isValid("([)]"));
        System.out.println(new Solution().isValid("{[]}"));
        System.out.println(new Solution().isValid("){"));
    }

    static class Solution {
        public boolean isValid(String s) {
            boolean answer = false;

            if(s.length() % 2!=0) return answer;

            String[] val = s.split("");

            HashMap<String,String> map = new HashMap<String, String>();
            map.put("(",")");
            map.put("{","}");
            map.put("[","]");

            Stack<String> stack = new Stack<String>();

            for(int i = 0; i<val.length; i++){
                if(stack.isEmpty()){
                    stack.add(val[i]);
                    continue;
                }

                else{
                    try{
                        if(map.get(stack.peek()).equals(val[i])){
                            stack.pop();
                        }else if(val[i].equals("(") || val[i].equals("[") || val[i].equals("{")){
                            stack.add(val[i]);
                        }else{
                            return false;
                        }
                    }catch(Exception e){
                        return false;
                    }
                }
            }
            if(stack.isEmpty())
                answer = true;

            return answer;
        }
    }
}
