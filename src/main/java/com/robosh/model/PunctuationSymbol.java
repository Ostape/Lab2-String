package com.robosh.model;

public class PunctuationSymbol implements TextSymbol {
    private String punctuation;

    public PunctuationSymbol(String punctuation) {
        this.punctuation = punctuation;
    }

    public String getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(String punctuation) {
        this.punctuation = punctuation;
    }

    @Override
    public String toString() {
        return punctuation;
    }
}
