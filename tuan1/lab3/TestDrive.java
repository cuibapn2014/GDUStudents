package com.tuan1.lab3;

import java.util.Scanner;

import vn.edu.giadinh.main;

import java.util.List;
import java.util.ArrayList;

public class TestDrive {
    public static void main(String[] args) {
        List<Shape> array = new ArrayList<>();
        Shape shape;
        Scanner sc = new Scanner(System.in);
        int n = 0;
        Shape tr = new Triangle(3,7,5);
        System.out.println(tr.getArea());
        try {
            while (n < 5) {
                System.out.println("Chọn hình: 1/Circle  |   2/Triangle");
                if (sc.nextLine().equals("1")) {
                    double radius;
                    System.out.println("Nhập đường kính: ");
                    radius = sc.nextDouble();
                    shape = new Circle(radius);
                    array.add(shape);
                } else {
                    double s1, s2, s3;
                    System.out.println("Nhập cạnh 1: ");
                    s1 = sc.nextDouble();
                    System.out.println("Nhập cạnh 2: ");
                    s2 = sc.nextDouble();
                    System.out.println("Nhập cạnh 3: ");
                    s3 = sc.nextDouble();
                    shape = new Triangle(s1, s2, s3);
                    array.add(shape);
                }
                sc.nextLine();
                n++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Shape sh : array) {
            sh.printInfo();
        }
    }
}
