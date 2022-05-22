package com.doczilla.model;

import java.util.Date;
import lombok.Data;

@Data
public class Student {

    public Student(String name, String surname, String patronymic, Date dateOfBorn, String group) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBorn = dateOfBorn;
        this.group = group;
    }

    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private Date dateOfBorn;
    private String group;
}