package com.cos;

public class COSPRO_1급_Java_1차_3 {
    static class Pair{
        public int firstNum;
        public int secondNum;
    }

    static int func_a(int numA, int numB, char exp){
        if (exp == '+')
            return numA + numB;
        else if (exp == '-')
            return numA - numB;
        else
            return numA * numB;
    }

    static int func_b(String exp){
        for(int i = 0; i < exp.length(); i++){
            char e = exp.charAt(i);
            if(e == '+' || e == '-' || e == '*')
                return i;
        }
        return -1;
    }
    static Pair func_c(String exp, int idx){
        Pair ret = new Pair();
        ret.firstNum = Integer.parseInt(exp.substring(0, idx));
        ret.secondNum = Integer.parseInt(exp.substring(idx + 1));
        return ret;
    }

    static int solution(String expression) {
        int expIndex = func_b(expression);          // 빈칸 채우기
        Pair numbers = func_c(expression, expIndex);// 빈칸 채우기
        int result = func_a(numbers.firstNum, numbers.secondNum, expression.charAt(expIndex));// 빈칸 채우기
        return result;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        String expression = "123+12";
        int ret = solution(expression);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
