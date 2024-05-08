package com.demo.dto;

public class StudentDTO {
    private int studentID;
    private String name;
    private int age;
    private boolean gender;

    public StudentDTO() {}

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public StudentDTO(int studentID, String name, int age, boolean gender) {
        super();
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public StudentDTO(String name, int age, boolean gender) {
        super();
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "studentID=" + studentID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
