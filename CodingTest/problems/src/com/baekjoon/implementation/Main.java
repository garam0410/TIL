package com.baekjoon.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        System.out.println(new Solution().solution(4, "FRI",
                new int[]{6, 21, 23, 27, 28}));
        System.out.println(new Solution().solution(3, "SUN",
                new int[]{2, 6, 17, 29}));
    }

    static class Solution {

        static HashMap<String, Integer> days = new HashMap<>();

        public int solution(int leave, String day, int[] holidays) {
            // holiday를 모두 구한다.
            int answer = Integer.MIN_VALUE;

            days.put("MON",5);
            days.put("TUE",4);
            days.put("WED",3);
            days.put("THU",2);
            days.put("FRI",1);

            ArrayList<Integer> holidayList = new ArrayList<>();

            for(int i = 0; i<holidays.length; i++)
                holidayList.add(holidays[i]);

            if(days.get(day)!=null){
                int tmp = 1+days.get(day);
                do{
                    if(!holidayList.contains(tmp))
                        holidayList.add(tmp);
                    if(tmp+1 <=30 && !holidayList.contains(tmp+1))
                        holidayList.add(tmp+1);
                    tmp+=7;
                }while(tmp<=30);
            }

            else{
                if(day.equals("SAT")){
                    int tmp = 1;
                    do{
                        if(!holidayList.contains(tmp))
                            holidayList.add(tmp);
                        if(tmp+1 <=30 && !holidayList.contains(tmp+1))
                            holidayList.add(tmp+1);
                        tmp+=7;
                    }while(tmp<=30);
                }else{
                    int tmp = 1;
                    if(!holidayList.contains(tmp))
                        holidayList.add(tmp);
                    tmp+=6;

                    do{
                        if(!holidayList.contains(tmp))
                            holidayList.add(tmp);
                        if(tmp+1 <=30 && !holidayList.contains(tmp+1))
                            holidayList.add(tmp+1);
                        tmp+=7;
                    }while(tmp<=30);
                }
            }
            // 쉬는날 모두 정렬
            Collections.sort(holidayList);

            System.out.println(Arrays.toString(holidayList.toArray()));

            int cnt = 0;

            int startDay = 0;

            int idx = 0;

            while(true){
                int i;
                for(i = idx; i<holidayList.size()-1; i++) {
                    if (startDay == 0) {
                        startDay = holidayList.get(i);
                        cnt += holidayList.get(i + 1) - holidayList.get(i) - 1;
                    } else {
                        cnt += holidayList.get(i + 1) - holidayList.get(i) - 1;
                    }
                    try{

                        if ((cnt == leave) && (holidayList.get(i+2) - holidayList.get(i+1) -1 != 0)) {
                            answer = Math.max(answer, holidayList.get(i + 1) - startDay + 1);
                            startDay = 0;
                            cnt = 0;
                            idx++;
                            break;
                        } else if (cnt > leave) {
                            answer = Math.max(answer, holidayList.get(i) - startDay
                                    + cnt - cnt - leave);
                            startDay = 0;
                            cnt = 0;
                            idx++;
                            break;
                        }
                    }catch(Exception e){
                        if (cnt == leave) {
                            answer = Math.max(answer, holidayList.get(i + 1) - startDay + 1);
                            startDay = 0;
                            cnt = 0;
                            idx++;
                            break;
                        }
                    }
                }
                if(answer == Integer.MIN_VALUE) return 30;
                if(i==holidayList.size()-1) break;
            }

            return answer;
        }
    }
}
