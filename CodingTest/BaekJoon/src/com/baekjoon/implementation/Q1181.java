package com.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        String[] words = new String[N];

        for(int i = 0; i<N; i++)
            words[i] = bf.readLine();

        ArrayList<WordBook> bookList = new ArrayList<>();
        for(int i = 0; i<words.length; i++){

            bookList.add(new WordBook(words[i],words[i].length()));
        }

        Collections.sort(bookList);

        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i<bookList.size(); i++){
            if(!result.contains(bookList.get(i).word))
                result.add(bookList.get(i).word);
        }

        for(int i = 0; i< result.size(); i++)
            System.out.println(result.get(i));

    }

    static class WordBook implements Comparable<WordBook>{
        private String word;
        private int size;

        public WordBook(String word, int size){
            this.word = word;
            this.size = size;
        }

        @Override
        public int compareTo(WordBook o) {
            if(size - o.size == 0){
                return word.compareTo(o.word);
            }else
                return size - o.size;
        }
    }
}
