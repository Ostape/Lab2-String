package com.robosh.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private final static String UNUSEFUL_SPACES = "[\\s]{2,}";
    private final static String SUPERFLUOUS_SIGNS = "['\"“”]+";
    private final static String END_OF_LINE = "[.!?]+[\\s]";
    private final static String BETWEEN_WORDS = "[\\s,]+";
    private final static String WORD = "[a-zA-Z]+[-’]?[a-zA-Z]+";

    public static void main(String[] args) {
        //врахувати дефіс в слово!!!
        // word [a-zA-Z]+
        // delete superfluous signs []
        String text = readFile("file.txt")
                .replaceAll(UNUSEFUL_SPACES, " ")
                .replaceAll(SUPERFLUOUS_SIGNS, "");

        List<String> sentences = Arrays.asList(text.split(END_OF_LINE));
        showSentences(getSentencesWithDublicatedWords(sentences));
    }


    private static void showSentences(List<String> sentence) {
        for (String str: sentence) {
            System.out.println(str);
        }
    }

    private static List<String> getSentencesWithDublicatedWords(List<String> sentences){

        List<String> sentencesWithWords = new ArrayList<>();

        for (String sentence : sentences){
            String[] words = sentence.split(BETWEEN_WORDS);

            point:
            for (int j = 0; j < words.length-1; j++) {
                String word = words[j];
                for (int i = j+1; i < words.length; i++) {
                    if (word.matches(WORD) && word.equalsIgnoreCase(words[i])) {
                        sentencesWithWords.add(sentence);
                        break point;
                    }
                }
            }
        }
        return sentencesWithWords;
    }

}
