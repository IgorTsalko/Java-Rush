package com.javarush.task.task15.task1504;

import java.util.LinkedList;
import java.util.List;

/* 
ООП - книги
*/

public class Solution {
    public static void main(String[] args) {
        List<Book> books = new LinkedList<Book>();
        books.add(new MarkTwainBook("Tom Sawyer"));
        books.add(new AgathaChristieBook("Hercule Poirot"));
        System.out.println(books);
    }

    public static class MarkTwainBook extends Book {
        String title;

        public MarkTwainBook(String title) {
            super("Mark Twain");
            this.title = title;
        }

        public MarkTwainBook getBook() {
            return this;
        }

        public String getTitle() {
            return title;
        }
    }

    public static class AgathaChristieBook extends Book {
        String title;

        public AgathaChristieBook(String title) {
            super("Agatha Christie");
            this.title = title;
        }

        public AgathaChristieBook getBook() {
            return this;
        }

        public String getTitle() {
            return title;
        }
    }

    abstract static class Book {
        private String author;

        public Book(String author) {
            this.author = author;
        }

        public abstract Book getBook();

        public abstract String getTitle();

        private String getOutputByBookType() {
            if (this instanceof AgathaChristieBook)
                return author + ": " + getBook().getTitle() + " is a detective";
            else if (this instanceof MarkTwainBook)
                return getBook().getTitle() + " was written by " + author;
            else
                return "output";
        }

        public String toString() {
            return getOutputByBookType();
        }
    }
}
