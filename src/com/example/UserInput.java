package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter text (press Enter twice to finish input):");

        int wordCount = 0;
        int totalWordLength = 0;
        Map<String, Integer> wordFrequency = new HashMap<>();

        String line;
        while (true) {
            line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }

            String[] words = line.split("\\s+");
            for (String word : words) {
                wordCount++;
                totalWordLength += word.length();

                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        if (wordCount > 0) {
            double averageWordLength = (double) totalWordLength / wordCount;

            System.out.println("Total Words: " + wordCount);
            System.out.println("Average Word Length: " + averageWordLength);

            System.out.println("Word Frequency:");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } else {
            System.out.println("No words found in the input.");
        }

        scanner.close();
    }
}
