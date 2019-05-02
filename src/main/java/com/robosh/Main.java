package com.robosh;

import com.robosh.model.Text;
import com.robosh.service.ReadFile;
import com.robosh.service.TextParserService;
import com.robosh.service.UserInput;


public class Main {

    public static void main(String[] args) {
        String fileName = UserInput.inputFileName();
        String textFromFile = ReadFile.readFile(fileName);

        TextParserService textParserService = new TextParserService(textFromFile);
        Text text = textParserService.getText();

        Text newText = new Text(textParserService.getSentencesWithDuplicatedWords());
        System.out.println(newText);
    }

}
