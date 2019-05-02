package com.robosh.service;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReadFile {
    private ReadFile() {
    }

    public static String readFile(String fileName) {
        String path = "E:\\KPI\\StringLab2\\" + fileName;
        File file = new File(path);

        if (fileNotExists(file) || fileCannotRead(file)) {
            throw new IllegalArgumentException("Cannot find file or cannot read");
        }

        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(path), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    private static boolean fileNotExists(File file) {
        return !file.exists();
    }

    private static boolean fileCannotRead(File file) {
        return !file.canRead();
    }

}
