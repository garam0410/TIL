package com.cos;

public class COSPRO_1급_Java_2 {
    static String func_a(String str, int len){
        String padZero = "";
        int padSize = len - str.length(); // 빈칸 채우기
        for(int i = 0; i < padSize; i++)
            padZero += "0";
        return padZero + str;
    }

    static int solution(String binaryA, String binaryB) {
        int maxLength = Math.max(binaryA.length(), binaryB.length());
        if(maxLength > binaryA.length())
            binaryA = func_a(binaryA, maxLength);
        if(maxLength > binaryB.length())
            binaryB = func_a(binaryB, maxLength);

        int hammingDistance = 0;
        for(int i = 0; i < maxLength; i++)
            if(binaryA.charAt(i) != binaryB.charAt(i)) // 빈칸 채우기
                hammingDistance += 1;
        return hammingDistance;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        String binaryA = "10010";
        String binaryB = "110";
        int ret = solution(binaryA, binaryB);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
