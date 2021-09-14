package com.programmers;

import java.util.*;
import java.util.Map.Entry;

public class Weekly_4 {
    public static void main(String[] args){
        System.out.println(new Solution().solution(new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"},
                new String[]{"PYTHON", "C++", "SQL"}, new int[]{7,5,5}));
    }

    static class Solution {
        public String solution(String[] table, String[] languages, int[] preference) {
            String answer = "";
            // 정보를 담을 map
            HashMap<String, Integer> map = new HashMap<>();

            for(int i = 0; i<5; i++){
                int score = 0;
                String[] tables = table[i].split(" ");

                for(int j = 1; j<tables.length; j++){
                    for(int k = 0; k<languages.length; k++){
                        if(tables[j].equals(languages[k])){
                            score += (6-j) * preference[k];
                            break;
                        }
                    }
                }
                map.put(tables[0], score);
            }

            List<Entry<String,Integer>> entry = new ArrayList<Entry<String,Integer>>(map.entrySet());
            Collections.sort(entry, (obj1, obj2) -> {
                if(obj1.getValue().compareTo(obj2.getValue()) < 0)
                    return 1;
                else if (obj1.getValue()==obj2.getValue()){
                    return obj1.getKey().compareTo(obj2.getKey());
                }
                else
                    return -1;
            });
//            Collections.sort(entry, new Comparator<Entry<String,Integer>>(){
//                public int compare(Entry<String,Integer> obj1, Entry<String,Integer> obj2){
//                    if(obj1.getValue().compareTo(obj2.getValue()) < 0)
//                        return 1;
//                    else if (obj1.getValue()==obj2.getValue()){
//                        return obj1.getKey().compareTo(obj2.getKey());
//                    }
//                    else
//                        return -1;
//                }
//            });

            for(Entry<String,Integer> obj : entry){
                return obj.getKey();
            }

            return answer;
        }
    }
}
