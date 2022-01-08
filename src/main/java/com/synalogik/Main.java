package com.synalogik;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    /**
     * API to read the contents of a plain text file and enable the display of the
     * total number of words, the average word length, the most frequently occurring word length, and a
     * list of the number of words of each length
     *
     *Assuming a word is a series of characters separated by a space. Even including punctuation such as commas
     *Also numbers are words. Anything delimited by a space
     *
     * @param args Use as an argument for reading a txt file for parsing contents
     * @throws IOException
     */
    public static void main(String args[]) throws IOException {

        String filePath = "src/main/resources/short.txt";
        if (args.length > 0) filePath = args[0];
        Dictionary dict = new Dictionary(filePath);

        //Total word count
        System.out.println("Word count = " + dict.getWordCount());
        // Average word length
        System.out.println("Average word length = " + dict.getAverageWordLength());

        // Print each word length and the count of each:
        for (HashMap.Entry<Integer, MutableInt> entry : dict.getWordMap().entrySet())
        {
            System.out.println("Number of words of length: "+entry.getKey() + " is: " + entry.getValue().get());
        }

        // Word length with the highest count, print word length and how often it occurs
        System.out.print("The most frequently occuring word length is: " + dict.getHighestWordCount() + ", for word lengths:");
        for (Integer count : dict.getHighestCountDuplicates().get(dict.getHighestWordCount()))
        {
            System.out.print(" "+count);
        }
        System.out.println();
    }

}
