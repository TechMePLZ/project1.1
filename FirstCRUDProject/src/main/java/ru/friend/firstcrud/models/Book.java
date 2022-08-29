package ru.friend.firstcrud.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Book {
    private int book_id;

    @NotEmpty(message = "Заполните поле")
    private String name;

    @NotEmpty(message = "Заполните поле")
    private String author;



    @Min(value = 1920, message = "Год выпуска книги должен быть больше 1920 ")
    private int yearOfProduction;

    public Book(int book_id, String name, String author, int yearOfProduction) {
        this.book_id = book_id;
        this.name = name;
        this.author = author;
        this.yearOfProduction = yearOfProduction;
    }

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }
}
