package com.robosh.service;

import com.robosh.model.*;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.robosh.service.Regex.*;

public class TextParserService {

    private String inputFromFile;
    private Text text;

    public TextParserService(String inputFromFile) {
        this.inputFromFile = inputFromFile;
    }

    private void deleteUnUsefulSigns() {
        inputFromFile = inputFromFile
                .replaceAll(UNUSEFUL_SPACES, " ");
    }

    private List<String> getSentencesWithDuplicatedWords(List<String> sentences) {

        List<String> sentencesWithWords = new ArrayList<>();

        for (String sentence : sentences) {
            String[] words = sentence.split(BETWEEN_WORDS);

            point:
            for (int j = 0; j < words.length - 1; j++) {
                String word = words[j];
                for (int i = j + 1; i < words.length; i++) {
                    if (word.matches(WORD) && word.equalsIgnoreCase(words[i])) {
                        sentencesWithWords.add(sentence);
                        break point;
                    }
                }
            }
        }
        return sentencesWithWords;
    }

    public Text getText() {
        text = new Text();
        Sentence sentence;
        List<String> sentencesString = splitIntoSentences();
        Pattern pattern = Pattern.compile(TEXT_SYMBOLS);
        for (String line : sentencesString) {
            Matcher matcher = pattern.matcher(line);
            sentence = new Sentence();
            int startSymbols = 0;
            int endSymbols = 0;
            while (matcher.find()){
                endSymbols = matcher.start();
                sentence.addPartOfSentence(new PunctuationSymbol(line.substring(startSymbols, endSymbols)));
                sentence.addPartOfSentence(new Word(matcher.group()));
                startSymbols = matcher.end();
            }
            sentence.addPartOfSentence(new PunctuationSymbol(line.substring(startSymbols, line.length()-1)));
            text.addSentences(sentence);
        }

        return text;
    }

    public List<String> splitIntoSentences() {
        List<String> sentences = new LinkedList<>();
        deleteUnUsefulSigns();
        Pattern pattern = Pattern.compile(END_OF_LINE);
        Matcher matcher = pattern.matcher(inputFromFile);
        int startSentence = 0;
        while (matcher.find()) {
            int endSentence = matcher.end();
            sentences.add(inputFromFile.substring(startSentence, endSentence));
            startSentence = endSentence;
        }
        return sentences;
    }

}
