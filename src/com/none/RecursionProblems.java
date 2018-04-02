package com.none;

import java.util.*;


public class RecursionProblems {


    public int countWays(int n) {
        if (n < 0) {
            return 0;
        } else if(n == 0) {
            return 1;
        }
        return countWays(n-1) + countWays(n-2) + countWays(n-3);
    }

    public int countWaysMamoization(int n) {
        int [] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return countWaysMamoization(n, memo);
    }

    public int countWaysMamoization(int n, int[] memo) {
        if (n < 0) {
            return 0;
        } else if (n==0) {
            return 1;
        } else if (memo[n] > 1) {
            return memo[n];
        } else {
            memo[n] = countWaysMamoization(n-1, memo) + countWaysMamoization(n-2, memo) + countWaysMamoization(n-3, memo);
            return memo[n];
        }
    }


    public int magicFast(int[] array) {
        return magicFast(array, 0, array.length - 1);
    }

    public int magicFast(int [] array, int start, int end) {
        if (end < start) {
            return -1;
        }
        int mid = (start + end) / 2;
        if(array[mid] == mid) {
            return mid;
        } else if (array[mid] > mid) {
            return magicFast(array, start, mid - 1);
        } else {
            return magicFast (array, mid + 1, end);
        }
    }

    // Look into it
    public static Set<Set<String>> findPowerSet2(Set<String> set){
        Set<Set<String>> result = new HashSet<>();
        result.add(new HashSet<String>());

        for(String element : set){
            Set<Set<String>> previousSets = new HashSet<>(result);
            for (Set<String> subSet : previousSets) {
                Set<String> newSubSet = new HashSet<String>(subSet);
                newSubSet.add(element);
                result.add(newSubSet);
            }
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> getSubsets (ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allsubsets;
        if(set.size() == index) {
            allsubsets = new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<Integer>());
        } else {
            allsubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> subset: allsubsets) {
                ArrayList<Integer> newsubset = new ArrayList<Integer>();
                newsubset.addAll(subset);
                newsubset.add(item);
                moresubsets.add(newsubset);
            }
            allsubsets.addAll(moresubsets);
        }
        return allsubsets;
    }

    public ArrayList<String> getPerms(String str) {
        if (str == null) return null;

        ArrayList<String> permutations = new ArrayList<String>();
        if (str.length() == 0) {
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0);
        String remainder = str.substring(1);
        ArrayList<String> words = getPerms(remainder);
        for(String word: words) {
            for (int  j =0; j< word.length(); j++) {
                String s = insertCharAt(word, first, j);
                permutations.add(s);
            }
        }
        return permutations;
    }

    public String insertCharAt (String word, char c, int i) {
        String start = word.substring(0,i);
        String end = word.substring(i);
        return start + c + end;
    }

    public void brackets(int openStock, int closeStock, String s) {
        if(openStock == 0 && closeStock == 0) {
            System.out.println(s);
        }
        if(openStock > 0) {
            brackets(openStock -1, closeStock +1, s + "<");
        }
        if(closeStock > 0) {
            brackets(openStock, closeStock-1, s + ">");
        }
    }

    public int makeChange (int n) {
        int[] denoms = {25, 10, 5, 1};
        return makeChange(n, denoms, 0);
    }

    public int makeChange(int amount, int[] denoms, int index) {
        if (index >= denoms.length - 1) return 1;

        int denomAmount = denoms[index];
        int ways = 0;
        for(int i = 0; i * denomAmount <  amount; i++) {
            int amountRemaining = amount - i * denomAmount;
            ways += makeChange(amountRemaining, denoms, index+1);
        }
        return ways;
    }
}
