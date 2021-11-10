package com.cos;

import java.util.Arrays;
import java.util.HashMap;

public class COSPRO_1급_Java_2차_6 {
    //LRUD
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};

    static int[] solution(String commands) {

        int[] answer = {};

        HashMap<String,Integer> changeDirection = new HashMap<>();

        changeDirection.put("L",0);
        changeDirection.put("R",1);
        changeDirection.put("U",2);
        changeDirection.put("D",3);

        answer = new int[2];

        String[] command = commands.split("");

        for(int i = 0; i<command.length; i++){
            answer[0] += dx[changeDirection.get(command[i])];
            answer[1] += dy[changeDirection.get(command[i])];
        }

        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        String commands = "URDDL";
        int[] ret = solution(commands);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + Arrays.toString(ret) + " 입니다.");
    }
}
