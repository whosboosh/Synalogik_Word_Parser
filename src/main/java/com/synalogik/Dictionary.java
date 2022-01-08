package com.synalogik;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Dictionary {
    private File fileDir;

    private int wordCount;
    private int totalCharCount;
    private int averageWordLength;
    private HashMap<Integer, MutableInt> wordMap;
    private int charCount;
    private int highestWordCount;
    private HashMap<Integer, ArrayList<Integer>> highestCountDuplicates;

    public Dictionary(String filePath)
    {
        fileDir = new File(filePath);
        parseFile();
    }


    public void calculateHighestWordCount()
    {
        // Calculate the word with the highest count
        // Use another hashmap whose key is the frequency of a word length. Useful for knowing what word lengths have the highest count and if any 2 or more have the same count, we can append that to the arraylist
        highestWordCount = 0;
        highestCountDuplicates = new HashMap<>();
        for (HashMap.Entry<Integer, MutableInt> j : wordMap.entrySet())
        {
            // Create a new array list if one doesn't exist already
            if (highestCountDuplicates.get(j.getValue().get()) == null) highestCountDuplicates.put(j.getValue().get(), new ArrayList<>());
            highestCountDuplicates.get(j.getValue().get()).add(j.getKey()); // Add any keys to the arraylist if the count is the same. (Useful for listing the highest word count later on if 2 or more lengths have the same count)

            if (j.getValue().get() > highestWordCount) highestWordCount = j.getValue().get(); // Keep track of the highest count

            // Print each word length and the count of each:
            //System.out.println("Number of words of length: "+j.getKey() + " is: " + j.getValue().get());
        }
    }

    public void parseFile()
    {
        wordCount = 0;
        totalCharCount = 0;
        wordMap = new HashMap<>();
        try {
            Scanner scanner = new Scanner(new FileInputStream(fileDir), "UTF-8");

            while (scanner.hasNext())
            {
                String word = scanner.next();
                Integer charCount = word.length();

                // MutableInt class provides using with utility functions to better manage null instances of int
                MutableInt count = wordMap.get(charCount);
                if (count == null) wordMap.put(charCount, new MutableInt());
                else count.increment();

                wordCount++; // Keep track of total words
                totalCharCount+=charCount; // Keep running total of characters for average word length
            }
        } catch(Exception e)
        {
            System.err.println(e);
        }

        calculateHighestWordCount();
    }

    public int getWordCount() { return wordCount; }
    public double getAverageWordLength() { return (double)totalCharCount / wordCount; }
    public HashMap<Integer, ArrayList<Integer>> getHighestCountDuplicates() { return highestCountDuplicates; }
    public HashMap<Integer, MutableInt> getWordMap() { return wordMap; }
    public int getHighestWordCount() { return highestWordCount; }
}
