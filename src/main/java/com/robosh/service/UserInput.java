package com.robosh.service;

import java.util.Scanner;

public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    private UserInput(){}

    public static String inputFileName(){
        return scanner.next();
    }
}
