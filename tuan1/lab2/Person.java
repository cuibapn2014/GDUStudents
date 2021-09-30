package com.tuan1.lab2;

public class Person {
    protected String myName;
    protected int myAge;
    protected String myGender;

    public Person() {
    }

    public Person(String name, int age, String gender) {
        this.myName = name;
        this.myAge = age;
        this.myGender = gender;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public int getMyAge() {
        return myAge;
    }

    public void setMyAge(int myAge) {
        this.myAge = myAge;
    }

    public String getMyGender() {
        return myGender;
    }

    public void setMyGender(String myGender) {
        this.myGender = myGender;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.myName + ", age:" + this.myAge + ", gender:" + this.myGender;
    }
}
