package com.ex;

public class greedy_ex2 {
    public static void main(String[] args){
        int N = 17;
        int K = 4;
        int cnt = 0;

        while(true){
            //N이 K로 나누어 떨어지는 수가 될 때까지 빼기
            int target = (N/K) * K;
            cnt += N - target;
            N=target;
            //N이 K보다 작을 때, 반복문 탈출
            if(N<K)
                break;

            cnt +=1;
            N /= K;
        }
        cnt += (N-1);
        System.out.println(cnt);
    }
}
