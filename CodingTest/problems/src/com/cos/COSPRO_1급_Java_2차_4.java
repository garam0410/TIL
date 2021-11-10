package com.cos;

public class COSPRO_1급_Java_2차_4 {
    static boolean[] check;
    static int arr_len;
    static int result = 0;

    static int solution(int[] arr, int K) {

        arr_len = arr.length;

        check = new boolean[arr_len];

        rec_func(0, 0, 0, K, arr);

        return result;
    }

    static void rec_func(int idx, int cnt, int value, int K, int[] arr){
        if(cnt == 3){
            if(value % K == 0){
                result++;
            }
        }else{
            for(int i = idx; i<arr_len; i++){
                if(check[i] == false){
                    check[i] = true;
                    rec_func(i+1,cnt+1,value+arr[i], K, arr);
                    check[i] = false;
                }
            }
        }
    }
    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int K = 3;
        int ret = solution(arr, K);


        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
