package com.none;

import java.util.*;

import static sun.jvm.hotspot.code.CompressedStream.L;

public class RecursionProblems {

    powerSet = new HashSet<List<String>>();
    List<String> mainList;

    {
        mainList = new ArrayList<String>(L);
    }

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
}
