package com.chaptertwo.methods;

import java.util.Scanner;

public class MethodOne {

    private String name;

    public static void main(String[] args) {
        MethodOne methodOne = new MethodOne();
        Scanner sc = new Scanner(System.in);

        methodOne.name = "Majeed Kanoor";

        String output = methodOne.printName(methodOne.name);
        System.out.println(methodOne.name);
    }

    public String printName(String name) {
        return "Hello, " + name;
    }
}
