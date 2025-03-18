package com.example.excelparser.model;

public class ExcelRow {
    private String name;
    private int age;
    private String email;

    // Constructor
    public ExcelRow() {}

    public ExcelRow(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
