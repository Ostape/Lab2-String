package com.robosh.service;

import com.robosh.model.*;

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

    public Text getText() {
        parseIntoTextClass();
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public String getInputFromFile() {
        return inputFromFile;
    }

    public void setInputFromFile(String inputFromFile) {
        this.inputFromFile = inputFromFile;
    }

    public Text getTextWithDublicatedSentences() {
        parseIntoTextClass();
        return new Text(getSentencesWithDuplicatedWords());
    }

    private List<Sentence> getSentencesWithDuplicatedWords() {
        List<Sentence> duplicatedSentences = new LinkedList<>();
        for (Sentence sentence : text.getSentences()) {
            int size = sentence.getPartOfSentence().size();
            List<TextSymbol> textSymbols = sentence.getPartOfSentence();
            foundedDublicatedWords:
            for (int i = 0; i < size - 1; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (isWord(textSymbols.get(i)) &&
                            textSymbols.get(i).equals(textSymbols.get(j))) {
                        duplicatedSentences.add(sentence);
                        break foundedDublicatedWords;
                    }
                }
            }
        }
        return duplicatedSentences;
    }

    private void parseIntoTextClass() {
        text = new Text();
        Sentence sentence;
        List<String> sentencesString = splitIntoStringSentences();
        Pattern pattern = Pattern.compile(TEXT_SYMBOLS);
        for (String line : sentencesString) {
            Matcher matcher = pattern.matcher(line);
            sentence = new Sentence();
            int startSymbols = 0;
            int endSymbols = 0;
            while (matcher.find()) {
                endSymbols = matcher.start();
                sentence.addPartOfSentence(new PunctuationSymbol(line.substring(startSymbols, endSymbols)));
                sentence.addPartOfSentence(new Word(matcher.group()));
                startSymbols = matcher.end();
            }
            sentence.addPartOfSentence(new PunctuationSymbol(line.substring(startSymbols, line.length() - 1)));
            text.addSentences(sentence);
        }
    }

    private List<String> splitIntoStringSentences() {
        List<String> sentences = new LinkedList<>();
        deleteUnusefulSpaces();
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

    private void deleteUnusefulSpaces() {
        inputFromFile = inputFromFile
                .replaceAll(UNUSEFUL_SPACES, " ");
    }

    private boolean isWord(TextSymbol symbol) {
        return symbol.getSymbol().matches(WORD);
    }
}
