package com.robosh.model;

import java.util.List;

public class Text {
    private List<Sentence> sentences;

    public Text(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }
}
