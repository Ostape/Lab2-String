package com.robosh.service;

public abstract class Regex {
    public final static String UNUSEFUL_SPACES = "[\\s]{2,}";
    public final static String SUPERFLUOUS_SIGNS = "['\"“”]+";
    public final static String END_OF_LINE = "[.!?]+[\\s]";
    public final static String BETWEEN_WORDS = "[\\s,]+";
    public final static String WORD = "[a-zA-Z]+[-’]?[a-zA-Z]+";
}
