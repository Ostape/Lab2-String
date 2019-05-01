package com.robosh.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ReadFile {
    private ReadFile(){}

    public static String readFile(String fileName) {
        String path = "E:\\KPI\\StringLab2\\" + fileName;
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(path), StandardCharsets.UTF_8))){
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
}
