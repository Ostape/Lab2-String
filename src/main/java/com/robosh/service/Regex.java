package com.robosh.service;

public interface Regex {
    String UNUSEFUL_SPACES = "[ ]{2,}";
    String TEXT_SYMBOLS = "[\\w]+([’-]?[\\w]+)?";
    String QUOTES = "['\"“”]+";
    String END_OF_LINE = "[.!?]+[”]?[\\s]";
    String BETWEEN_WORDS = "[\\s,:;()[]{}]+";
    String WORD = "[a-zA-Z]+[-’]?[a-zA-Z]+";
}
