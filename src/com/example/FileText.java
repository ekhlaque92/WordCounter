package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileText {
    public static void main(String[] args) {
        String filePath = "Text.txt"; // Replace with the path to your text file
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int wordCount = 0;
            int totalWordLength = 0;
            Map<String, Integer> wordFrequency = new HashMap<>();

            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split the line into words using whitespace as the delimiter
                for (String word : words) {
                    wordCount++;
                    totalWordLength += word.length();

                    // Update word frequency
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }

            if (wordCount > 0) {
                double averageWordLength = (double) totalWordLength / wordCount;

                System.out.println("Total Words: " + wordCount);
                System.out.println("Average Word Length: " + averageWordLength);

                System.out.println("Word Frequency: ");
                for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            } else {
                System.out.println("No words found in the document.");
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
