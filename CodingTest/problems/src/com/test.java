package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class test {
    public static void main(String[] args) throws IOException {
        HashMap<Integer,Integer> map = new HashMap<>();

        int numOfRegion = 4;
        int numOfAttackableFrequency = 3;
        int[][] frequencies = new int[][]{{6,18,16,17,2,9,19},{8,2,16,3,11,6,19,15,17},{5,19,1,4,17,7},{6,16,3,6,19,14,12}};

        for(int i = 0; i<numOfRegion; i++){
            int size = frequencies[i][0];
            System.out.println(size);
            for(int j = 1; j<size+1; j++){
                map.put(frequencies[i][j],map.getOrDefault(map.get(frequencies[i][j]),0)+1);
                System.out.println(frequencies[i][j]);
            }
        }
        System.out.println(map);
    }
}
