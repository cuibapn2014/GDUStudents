package com.tuan1.lab2;

public class CollegeStudent extends Student {
    private String major;
    private int year;

    public CollegeStudent() {
    }

    public CollegeStudent(String name, int age, String gender, String idNum, double gpa, int year, String major) {
        super(name, age, gender, idNum, gpa);
        this.major = major;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + ", major:" + this.major + ", year: " + this.year;
    }
}