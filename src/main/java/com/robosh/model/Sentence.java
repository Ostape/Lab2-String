package com.robosh.model;

import java.util.LinkedList;
import java.util.List;

public class Sentence {

    private List<TextSymbol> partOfSentence;

    public Sentence() {
        partOfSentence = new LinkedList<>();
    }

    public Sentence(List<TextSymbol> partOfSentence) {
        this.partOfSentence = partOfSentence;
    }

    public List<TextSymbol> getPartOfSentence() {
        return partOfSentence;
    }

    public void setPartOfSentence(List<TextSymbol> partOfSentence) {
        this.partOfSentence = partOfSentence;
    }

    public void addPartOfSentence(TextSymbol partOfSentence) {
        this.partOfSentence.add(partOfSentence);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (TextSymbol part : partOfSentence) {
            string.append(part);
        }
        return string.toString();
    }
}
