package com.none;

import java.util.HashMap;

public class MediumProblems {

    public void wordFrequency(String[] book, String word) {
        System.out.println("-- via simple approach");
        word =  word.trim().toLowerCase();
        int count = 0;
        for (String w: book) {
            if(w.trim().toLowerCase().equals(word)) {
                ++count;
            }
        }
        System.out.println("count: " + count);

        System.out.println("-- via hashmap approach");

        HashMap<String, Integer> map = new HashMap<String,Integer>();

        for(String w: book) {
            if(w.trim() != "") {
                if (!map.containsKey(w.trim().toLowerCase())) {
                    map.put(w.trim().toLowerCase(), 0);
                }
                map.put(w.toLowerCase().trim(), map.get(w.trim().toLowerCase()) + 1);
            }
        }

        System.out.println("count: " + map.get(word.trim().toLowerCase()));
    }
}
