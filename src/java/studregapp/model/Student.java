package model;

public class Student {
    private String name;
    private String email;
    private String year;

    public Student(String name, String email, String year) {
        this.name = name;
        this.email = email;
        this.year = year;
    }

    // Getters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getYear() { return year; }
}