package com.baekjoon;

import java.util.*;

public class Main {
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String keyWord = sc.nextLine();
        List<String> list = new ArrayList<>();
        Collections.addAll(list, keyWord.split(" "));
        List<Integer> numbers = list.stream().map(Integer::parseInt).toList();

        numbers.forEach(num -> result += num);

        System.out.println(result);
    }
}
