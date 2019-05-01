package com.robosh.model;

public class NotWord implements TextSymbol {
    private String notWord;

    public NotWord(String notWord) {
        this.notWord = notWord;
    }

    public String getNotWord() {
        return notWord;
    }

    public void setNotWord(String notWord) {
        this.notWord = notWord;
    }

    @Override
    public String toString() {
        return notWord;
    }
}
