package main.java;

import java.util.*;
import java.util.stream.Collectors;

public class Stream {

    // 책들 중 니체가 작성한 책의 ISBN 정보가 필요
    // 정렬은 책 이름을 기준으로!

    public static void main(String[] args){
        // 기존 책 목록
        List<Book> books = makeList();
        viewBookList(books);

        // 기본 스트림 사용
        List<String> normalBookName = normalStream(books);
        // 스트림 고급 사용
        List<String> expertBookName = expertStream(books);

        // 출력
        viewNameList(normalBookName);
        viewNameList(expertBookName);
    }

    public static List<String> normalStream(List<Book> books){
        books.sort(Comparator.comparing(Book::getName));

        List<String> booksWrittenByNietzsche = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals("Friedrich Nietzsche")) {
                booksWrittenByNietzsche.add(book.getIsbn());
            }
        }

        return booksWrittenByNietzsche;
    }

    public static List<String> expertStream(List<Book> books){
        List<String> booksWrittenByNietzsche =
                books.stream()
                        .filter(book -> book.getAuthor().equals("Friedrich Nietzsche"))
                        .sorted(Comparator.comparing(Book::getName))
                        .map(Book::getIsbn)
                        .collect(Collectors.toList());

        return booksWrittenByNietzsche;
    }

    public static List<Book> makeList(){
        List<Book> bookList = new ArrayList<>();

        for(int i = 0; i<5; i++){
            bookList.add(
                Book.builder()
                        .isbn(String.valueOf(new Random().nextInt(100)))
                        .author("Friedrich Nietzsche")
                        .name("book" + new Random().nextInt(20))
                        .build()
            );
        }

        System.out.println();

        return bookList;
    }

    public static void viewBookList(List<Book> list){
        for(Book book : list){
            System.out.println(book);
        }
        System.out.println();
    }

    public static void viewNameList(List<String> list){
        for(String name : list){
            System.out.println(name);
        }
        System.out.println();
    }
}
