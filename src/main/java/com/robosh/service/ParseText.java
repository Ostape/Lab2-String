package com.robosh.service;

import com.robosh.model.Sentence;
import com.robosh.model.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.robosh.service.Regex.END_OF_LINE;

public class ParseText {

    public static Text getText(String input){
        List<Sentence> sentences  = new ArrayList<>();

        sentences = Arrays.asList(input.split(END_OF_LINE));

        return new Text(sentences);
    }
}
