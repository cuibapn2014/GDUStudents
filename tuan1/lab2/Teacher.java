package com.tuan1.lab2;

public class Teacher extends Person {
    private String subject;
    private double salary;

    public Teacher() {
    }

    public Teacher(String name, int age, String gender, String subject, double salary) {
        super(name, age, gender);
        this.subject = subject;
        this.salary = salary;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + ", Subject: " + this.subject + ", salaty:" + this.salary;
    }
}