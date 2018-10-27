package com.sda.Day11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String text = "Ala ma kota ja mam ale kot ma ale ale ale";
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

        int often = 0;
        int rarest = 0;

        for (int i = 0; i < splittedText.length - 1; i++) {
            if (i == 0) {
                often = uniqueWordsCounter.get(splittedText[i]);
            }
            if (uniqueWordsCounter.get(splittedText[i]) > uniqueWordsCounter.get(splittedText[i + 1])) {
                often = uniqueWordsCounter.get(splittedText[i]);
            } else {
                often = uniqueWordsCounter.get(splittedText[i + 1]);
            }
        }

        for (int i = 0; i < splittedText.length - 1; i++) {
            if (i == 0) {
                rarest = uniqueWordsCounter.get(splittedText[i]);
            }
            if (uniqueWordsCounter.get(splittedText[i]) < uniqueWordsCounter.get(splittedText[i + 1])) {
                rarest = uniqueWordsCounter.get(splittedText[i]);
            }
        }

        for (int i = 0; i < splittedText.length; i++) {
            if (uniqueWordsCounter.get(splittedText[i]) == often) {
                System.out.print(splittedText[i] + "\t");
            }
        }

        System.out.println();

        for (int i = 0; i < splittedText.length; i++) {
            if (uniqueWordsCounter.get(splittedText[i]) == rarest) {
                System.out.print(splittedText[i] + "\t");
            }
        }

        String longest = null;
        String shortest = null;

        for (int i = 0; i < splittedText.length; i++) {
            if (i == 0) {
                longest = shortest = splittedText[i];
                continue;
            }
            if (splittedText[i].length() > longest.length()) {
                longest = splittedText[i];
            }
        }

        for (int i = 0; i < splittedText.length; i++) {
            if (splittedText[i].length() < shortest.length()) {
                shortest = splittedText[i];
            }
        }

        System.out.println();
        System.out.println("Najdluzsze slowo: " + longest);
        System.out.println("Najkrotsze slowo: " + shortest);
    }
}
