package com.it_academy;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Random;


public class TestM {

    @Test
    void convertStringListsToNames() {
        String[] lines = new String[10];;

        for (int i = 0; i<10; i++) {
            lines[i] = randomStringFromArr();
        }

        System.out.println("Original array:");
        printArray(lines);

        for (int i = 0; i<10; i++) {
            lines[i] = StringUtils.lowerCase(lines[i]);
            lines[i] = StringUtils.capitalize(lines[i]);
        }

        System.out.println();
        System.out.println("Result:");
        printArray(lines);
    }

    static String randomStringFromArr() {
        String alphabet =
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                        "abcdefghijklmnopqrstuvwxyz";

        StringBuilder b = new StringBuilder();

        int lineLength = 10;
        for (int i = 0; i < lineLength; i++) {
            int randIdx;
            randIdx = new Random().nextInt(alphabet.length());
            char randChar = alphabet.charAt(randIdx);
            b.append(randChar);
        }
        return b.toString();
    }

    void printArray(String[] lines) {
        for (int i = 0; i<10; i++) {
            System.out.println(lines[i]);
        }
    }
}
