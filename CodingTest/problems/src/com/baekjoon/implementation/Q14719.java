package com.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Q14719 {
    public static void main(String[] args) throws IOException {
        int answer = 0;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Stack> world = new ArrayList<>();

        String[] vals = bf.readLine().split(" ");

        int h = Integer.parseInt(vals[0]);
        int w = Integer.parseInt(vals[1]);

        vals = bf.readLine().split(" ");

        int[] block = new int[w];

        for(int i = 0; i<w; i++){
            block[i] = Integer.parseInt(vals[i]);
        }

        for(int i = 0; i<w; i++){
            Stack<Integer> stack = new Stack<>();

            while(block[i]!=0){
                stack.push(1);
                block[i]--;
            }
            world.add(stack);
        }

//        for(int i = 0; i<world.size(); i++){
//            System.out.println(world.get(i).size());
//        }

        for(int i = 0; i<h; i++){
            for(int j = 1; j<w-1; j++){
                int tmp = world.get(j).size();
                if(tmp<world.get(j-1).size() && tmp<world.get(j+1).size()){
//                    System.out.println("전 : " + Arrays.toString(world.toArray()));
                    world.get(j).push(1);
//                    System.out.println("후 : " + Arrays.toString(world.toArray()));
//                    System.out.println();
                    answer++;
                }else if(tmp==world.get(j+1).size() && tmp<world.get(j-1).size()){
                    int idx = j;
                    while(world.get(idx).size()<=tmp){
//                        System.out.println("전 : " + Arrays.toString(world.toArray()));
                        world.get(idx).push(1);
//                        System.out.println("후 : " + Arrays.toString(world.toArray()));
//                        System.out.println();
                        idx++;
                        answer++;
                        if(idx == w){
                            answer -= idx - j;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
