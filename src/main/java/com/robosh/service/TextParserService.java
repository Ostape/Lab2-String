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

    private void deleteUnUsefulSigns() {
        inputFromFile = inputFromFile
                .replaceAll(UNUSEFUL_SPACES, " ");
    }

    public List<Sentence> getSentencesWithDuplicatedWords(){
        List<Sentence> duplicatedSentences = new LinkedList<>();
        for (Sentence sentence : text.getSentences()){
            int size = sentence.getPartOfSentence().size();
            List<TextSymbol> textSymbols = sentence.getPartOfSentence();
            point:
            for (int i = 0; i < size-1; i++){
                for (int j = i+1; j < size; j++){
                    if (isWord(textSymbols.get(i)) &&
                            textSymbols.get(i).equals(textSymbols.get(j))){
                        duplicatedSentences.add(sentence);
                        break point;
                    }
                }
            }
        }
        return duplicatedSentences;
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

    private boolean isWord(TextSymbol symbol){
        return symbol.getSymbol().matches(WORD);
    }
}
