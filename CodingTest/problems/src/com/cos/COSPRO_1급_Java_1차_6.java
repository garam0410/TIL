package com.cos;

import java.util.HashMap;

public class COSPRO_1급_Java_1차_6 {
    static HashMap<String, Integer> map = new HashMap<>();
    static int[] dx = {-1,1,-1,1,-2,-2,2,2};
    static int[] dy = {-2,-2,2,2,1,-1,1,-1};

    static int solution(String pos) {
        int answer = 0;

        map.put("A",0);
        map.put("B",1);
        map.put("C",2);
        map.put("D",3);
        map.put("E",4);
        map.put("F",5);
        map.put("G",6);

        String[] vals = pos.split("");

        int x = 8 - Integer.parseInt(vals[1]);
        int y = map.get(vals[0]);

        for(int i = 0; i<8; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(cx<=-1 || cy<=-1 || cx>=8 || cy >= 8)
                continue;
            else
                answer++;
        }


        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        String pos = "A7";
        int ret = solution(pos);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
