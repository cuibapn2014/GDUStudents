package com.tuan1.lab1;

public class TestBook {
    public static void main(String[] args) {
        Author anAuthor = new Author("Tuan Nguyen", "testthu@gmail.com", 'm');
        Book aBook = new Book("Java for dummy", anAuthor, 19.95d, 1000);
        Book anotherBook = new Book("more Java for dummy", new Author("Nguyen Manh Tuan", "manhtuan@gmail.com", 'm'),
                29.95d, 888);
        System.out.println(anotherBook.toString());
        System.out.println(anotherBook.getAuthor().toString());
    }
}
