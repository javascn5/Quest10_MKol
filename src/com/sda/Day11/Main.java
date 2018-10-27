package com.sda.Day11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String text = "Ala ma kota ja mam ale kot ma ale";
        String[] splittedText = text.split(" ");

        Map<String, Integer> uniqueWordsCounter = new HashMap<>();      //hashMMapa

        for (String word : splittedText) {
            boolean isUnique = true;
            for (String uniqueWord : uniqueWordsCounter.keySet()) {
                if (word.equals(uniqueWord)) {
                    isUnique = false;
                    int count = uniqueWordsCounter.get(word);           //ilosc wystapienia danego slowa
                    uniqueWordsCounter.put(word, ++count);
                    break;
                }
            }
            if (isUnique) {
                uniqueWordsCounter.put(word, 1);
            }
        }
        System.out.println(uniqueWordsCounter);
    }
}
