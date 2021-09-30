package com.tuan1.lab3;

public class Circle extends Shape {
    private double radius;
    private final float PI = 3.14f;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        // TODO Auto-generated method stub
        return 2 * this.radius * this.radius * this.PI;
    }

    @Override
    public double getPrimeter() {
        // TODO Auto-generated method stub
        return 2 * this.radius * this.PI;
    }

    @Override
    public void printInfo() {
        // TODO Auto-generated method stub
        super.printInfo();
        System.out.println("Area: " + this.getArea() + ", Primeter: " + this.getPrimeter());
    }
}