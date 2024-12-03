package com.example.android_konyvtar;

import java.util.Random;

public class Book {
    private String title;
    private String author;
    private int pages;

    public int getYear() {
        return year;
    }

    private int year;

    public Book(String title, String author, int pages) {
        Random rand = new Random();
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.year = rand.nextInt(2024-1500)+1500;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}