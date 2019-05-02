package com.robosh.model;

import java.util.LinkedList;
import java.util.List;

public class Text {
    private List<Sentence> sentences;

    public Text() {
        sentences = new LinkedList<>();
    }

    public Text(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public void addSentences(Sentence sentences) {
        this.sentences.add(sentences);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Sentence sentence: sentences) {
            str.append(sentence).append("\n");
        }
        return str.toString();
    }
}
