package com.none;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.*;

public class ArraysAndStringProblems {

    public boolean stringHasUniqueCharacters(String str) {
        if (str.length() > 128) return false;

        boolean[] char_set = new boolean[128];

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {
                System.out.println("String has duplicate character!");
                return false;
            }
            char_set[val] = true;
        }
        System.out.println("String has unique characters");
        return true;
    }


    public boolean checkPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            System.out.println("Str1 is not a permutation of Str2");
            return false;
        }

        char arr1[] = str1.toCharArray();
        char arr2[] = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr1);

        if (arr1.equals(arr2)) {
            System.out.println("Str1 and str2 are permutations of each other");
        }
        else{
            System.out.print("Str1 is not a permutation of Str2");
            return false;
        }
        return true;
    }


    public void URLify(String str1) {
        System.out.println("My approach");

        String str2 = str1.replace(" ", "%20");
        System.out.println(str1 + " ---> " + str2);

        System.out.println("Approach from the book:");

        int trueLength = str1.length();
        char str[] = new char[100];
        int spaceCount = 0, index, i = 0;

        for (i = 0; i<trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2;

        if (trueLength < str.length) str[index] = '\0';
        for (i = trueLength - 1; i >= 0; i--) {
            if(str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index] = str[i];
                index--;
            }

        }
//        System.out.println(str);
    }

    public void palindromPermutation(String phrase) {
        Set<Character> oddLetter = new HashSet<>();
        for(char c: phrase.toCharArray()) {
            if(!oddLetter.remove(c)) {
                oddLetter.add(c);
            }
        }
        if(oddLetter.size() > 1) {
            System.out.println("Str cannot make a palindrome with permutation");
        }
        else {
            System.out.println("Str CAN make a palindrome with permutation");
        }
    }

}
