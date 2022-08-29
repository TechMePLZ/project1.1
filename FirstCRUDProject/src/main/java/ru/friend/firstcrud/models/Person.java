package ru.friend.firstcrud.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {

    private int person_id;

    @NotEmpty(message = "Заполните поле")
    @Size(min = 3, max = 60, message = "ИМЯ должно быть минмимум из трех букв")
    private String name;

    @Min(value = 1920, message = "Год рождения должен быть больше 1920 ")
    private int year_of_birth;

    public Person(int person_id, String name, int year_of_birth) {
        this.person_id = person_id;
        this.name = name;
        this.year_of_birth = year_of_birth;
    }
    // for spring
    public Person() {
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear_of_birth() {
        return year_of_birth;
    }

    public void setYear_of_birth(int year_of_birth) {
        this.year_of_birth = year_of_birth;
    }
}
