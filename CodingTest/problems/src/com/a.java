package com;

import java.util.*;

public class a {
    public static void main(String[] args){
//        System.out.println(Arrays.toString(new Solution().solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},2)));
//        System.out.println(Arrays.toString(new Solution().solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"},3)));
        //System.out.println(new Solution().solution(437674,3));
        //System.out.println(new Solution().solution(110011,10));
//        for(int i = 10000; i<=1000000; i++){
//            for(int j = 3; j<=10; j++){
//                System.out.println(i + " : " + j);
//                System.out.println(new Solution().solution(i,j));
//            }
//        }
        System.out.println(new Solution().solution(1001101011,10));
//        System.out.println(new Solution().solution(117011,10));
    }

    static class Solution {
        static boolean[] check;

        public int solution(int n, int k) {
            int answer = 0;
            // 일단 진수를 변환하자
            // 그리고 0을 기준으로 split 하자
            // 정렬을 통해서 가장 큰 수를 기준으로 에라토스테네스의 체를 이용해서 소수 판별한다.
            // 소수인 것의 개수를 카운트해서 return
            String[] arr = change(n,k).split("0");
            System.out.println(change(n,k));
            //int[] numbers = new int[arr.length];
            ArrayList<Integer> numbers = new ArrayList<>();

            for(int i = 0; i<arr.length; i++){
                if(!arr[i].equals("")){
                    numbers.add(Integer.parseInt(arr[i]));
                }
            }

            System.out.println(Arrays.toString(numbers.toArray()));
//
//            String[] arr = change(n,k).split("");
//            String tmp = "";
//            for(int i = 0; i<arr.length; i++){
//                if(!arr[i].equals("0")){
//                    tmp += arr[i];
//                }else if(arr[i].equals("0") && tmp.equals("")){
//                    continue;
//                }else{
//                    numbers.add(Integer.parseInt(tmp));
//                    tmp = "";
//                }
//                if(i==arr.length-1 && !tmp.equals(""))
//                    numbers.add(Integer.parseInt(tmp));
//            }

            Collections.sort(numbers);


            try{
                checkSosu(numbers.get(numbers.size()-1));
            }catch(Exception e){
//                if(numbers.size()==0 && numbers.)
            }

//            for(int i = 0; i<check.length; i++){
//                if(check[i]==true)
//                    System.out.println(i);
//            }

            for(int i = 0; i<numbers.size(); i++){
                if(check[numbers.get(i)] == true)
                    answer +=1;
            }

            return answer;
        }

        // 진수변환기
        static String change(int n, int k){
            StringBuilder sb = new StringBuilder();
            while(n >= 1){
                sb.append(n % k);
                n /= k;
            }
            return sb.reverse().toString();
        }

        static void checkSosu(int val){
            check = new boolean[val+1];

            check[0] = check[1] = false;
            for(int i=2; i<=val; i+=1) {
                check[i] = true;
            }

            //2 부터 숫자를 키워가며 배수들을 제외(false 할당)
            for(int i=2; i*i<=val; i+=1) {
                for(int j=i*i; j<=val; j+=i) {
                    check[j] = false;        //2를 제외한 2의 배수 false
                }
            }
        }
    }
}
