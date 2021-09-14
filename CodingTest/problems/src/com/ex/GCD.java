package com.ex;

public class GCD {
    public static void main(String[] args){
        System.out.println(gcd(192,162));
    }

    static int gcd(int a, int b){
        // 나누어 떨어지면, b 리턴
        if(a % b == 0) return b;
        else
            // a와 b의 최대 공약수 gcd(a,b) 는 a를 b로 나눈 나머지(a%b) 와 b의 최대공약수와 같다 gcd(b, a%b)
            return gcd(b, a%b);
    }
}
