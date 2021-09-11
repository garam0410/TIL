package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class b {
    public static void main(String[] args){
        System.out.println(Arrays.toString(new Solution().solution(new int[]{180, 5000, 10, 600},
                new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"})));
    }

    static class Solution {
        public int[] solution(int[] fees, String[] records) {
            int[] answer = {};
            // 주차 요금 계산
            // fees[1] + ( (누적시간 - fee[0]) / fees[2] ) * fees[3];
            // 시:분을 분단위로 변환
            int endTime = (23*60) + 59; // 출차내역이 없을때 빼는 변수
            int normal = fees[0];

            ArrayList<Integer> tmp = new ArrayList<>();

            for(int i = 0; i<records.length; i++){
                String[] val = records[i].split(" ");
                if(!tmp.contains(Integer.parseInt(val[1])))
                    tmp.add(Integer.parseInt(val[1]));
            }

            Collections.sort(tmp);

            HashMap<String,Integer> carList = new HashMap<>();
            for(int i = 0; i<tmp.size(); i++)
                carList.put(String.format("%04d",tmp.get(i)), i);

            for(String key : carList.keySet())
                System.out.println(key + " : " +carList.get(key));

            ArrayList<ArrayList<Integer>> timeCheck = new ArrayList<>();
            for(int i = 0; i<carList.size(); i++)
                timeCheck.add(new ArrayList<>());

            // 시간 넣기
            for(int i = 0; i<records.length; i++){
                String[] val = records[i].split(" ");
                timeCheck.get(carList.get(val[1])).add(changeTime(val[0]));
            }

            //System.out.println(Arrays.toString(timeCheck.toArray()));

            for(int i = 0; i<timeCheck.size(); i++){
                int size = timeCheck.get(i).size();
                int result = 0;
                //System.out.println(size);
                for(int j = 0; j<size; j++){
                    if(j % 2 ==0){
                        result += timeCheck.get(i).get(j);
                    }else{
                        result -= timeCheck.get(i).get(j);
                    }
                }
                if(size % 2 != 0){
                    result -= endTime;
                }

                timeCheck.get(i).clear();
                timeCheck.get(i).add(Math.abs(result));
            }

            System.out.println(Arrays.toString(timeCheck.toArray()));

            answer = new int[timeCheck.size()];
            for(int i = 0; i<answer.length; i++){
                int value = timeCheck.get(i).get(0);

                if(timeCheck.get(i).get(0)<normal)
                    answer[i] = 5000;
                else{
                    if((value - fees[0]) % fees[2] == 0){
                        answer[i] = fees[1] + (((value - fees[0])/fees[2])) * fees[3];

                    }else{
                        answer[i] = fees[1] + (((value - fees[0])/fees[2])+1) * fees[3];
                    }
                }
            }

            return answer;
        }

        static int changeTime(String time){
            String[] val = time.split(":");

            int hour = Integer.parseInt(val[0]) * 60;
            int minute = Integer.parseInt(val[1]);

            return hour + minute;
        }
    }
}
