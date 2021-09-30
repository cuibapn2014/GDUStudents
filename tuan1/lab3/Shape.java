package com.tuan1.lab3;

public abstract class Shape {
    private String name;

    public Shape() {
    }

    public Shape(String name) {
        this.name = name;
    }

    public double getArea() {
        return 0;
    }

    public double getPrimeter() {
        return 0;
    }

    public void printInfo() {
        System.out.println("Name: " + this.name);
    }
}
