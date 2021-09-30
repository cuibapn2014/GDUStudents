package com.tuan1.lab3;

import java.math.*;

public class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double getArea() {
        double p = this.getPrimeter();
        return Math.sqrt(p * (p - this.side1) * (p - this.side2) * (p - this.side3));
    }

    @Override
    public double getPrimeter() {
        // TODO Auto-generated method stub
        return this.side1 + this.side2 + this.side3;
    }

    @Override
    public void printInfo() {
        // TODO Auto-generated method stub
        super.printInfo();
        System.out.println("Area: " + this.getArea() + ", Primeter: " + this.getPrimeter());
    }
}