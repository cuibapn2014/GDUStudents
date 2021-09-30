package com.tuan1.lab2;

public class Student extends Person {
    protected String myIdNum;
    protected double myGPA;

    public Student() {
    }

    public Student(String name, int age, String gender, String idNum, double gpa) {
        super(name, age, gender);
        this.myIdNum = idNum;
        this.myGPA = gpa;
    }

    public String getMyIdNum() {
        return myIdNum;
    }

    public void setMyIdNum(String myIdNum) {
        this.myIdNum = myIdNum;
    }

    public double getMyGPA() {
        return myGPA;
    }

    public void setMyGPA(double myGPA) {
        this.myGPA = myGPA;
    }
}
