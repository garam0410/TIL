package com.ex;

import java.util.Arrays;

public class implementation_ex4 {
    public static void main(String[] args){
        //String[] s = "K1KA5CB7".split("");
        String[] s = "AJKDLSI412K4JSJ9D".split("");
        int sum = 0;
        String result = "";
        Arrays.sort(s);

        for(int i = 0; i<s.length; i++){
            try{
                if(Integer.parseInt(s[i])>=0 || Integer.parseInt(s[i])<=9){
                    sum += Integer.parseInt(s[i]);
                }
            }catch(Exception e){
                result += s[i];
            }
        }

        result += sum;
        System.out.println(result);
    }
}
