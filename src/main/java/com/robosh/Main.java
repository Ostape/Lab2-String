package com.robosh;

import com.robosh.model.Text;
import com.robosh.service.ReadFile;
import com.robosh.service.TextParserService;
import com.robosh.service.UserInput;

public class Main {
    public static void main(String[] args) {
        System.out.print("Input file name: ");
        String fileName = UserInput.inputFileName();
        String textFromFile = ReadFile.readFile(fileName);
        TextParserService textParserService = new TextParserService(textFromFile);
        Text newText = textParserService.getTextWithDublicatedSentences();
        System.out.println(newText);
    }
}
