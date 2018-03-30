package com.none;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main {

    public static void main(String[] args) {
        testMergeSort();
        testComparableComparator();
        testCountingSort();
        testRadixSort();
        testPriorityQueue();
        testPalindrome();
        testPermutation();
        testJUnit();
    }



    static void testMergeSort() {
        System.out.println("[*] Merge Sort Testing");
        int[] inputArr = {32,65,12,75,1,90,32,76,15,83};
        MergeSort ms = new MergeSort();
        ms.sort(inputArr);

        for(int i: inputArr) {
            System.out.print(i + " ");
        }
    }

    static void testComparableComparator() {
        System.out.println("\n\n[*] Comparable Testing");
        ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977 ));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));

        Collections.sort(list);

        System.out.println("Movies after sorting (YEAR): ");

        for (Movie movie: list) {
            System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
        }

        Collections.sort(list, new NameCompare());
        System.out.println("\nMovies after sorting (Name): ");

        for (Movie movie: list) {
            System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
        }

        Collections.sort(list, new RatingCompare());
        System.out.println("\nMovies after sorting (Rating): ");

        for (Movie movie: list) {
            System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
        }
    }

   static void testCountingSort() {
        System.out.println("\n\n[*] Counting Sort Testing");
        CountingSort cs = new CountingSort();
        char arr[] = {'g', 'w', 'i', 'a', 'n', 'z', 'y', 'k', 'q', 'b'};
        cs.sort(arr);

        System.out.println("Sorted Array: ");
        for(int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
    }

    static void testRadixSort() {
        System.out.println("\n\n[*] Radix Sort Testing");
        int arr[] = {2,543,76,12,86,12,100,86,1423,97};
        CountingSort cs = new CountingSort();
        cs.radixsort(arr, arr.length);
        cs.print(arr, arr.length);
    }

    static void testPriorityQueue() {
        System.out.println("\n\n[*] Priority Queue Testing");
        SalaryComparator sc = new SalaryComparator();

        PriorityQueue<Employee> myq = new PriorityQueue<Employee>(7, sc);

        myq.offer(new Employee("FEAF", 472398));
        myq.offer(new Employee("reeedew", 854));
        myq.offer(new Employee("fer", 654));
        myq.offer((new Employee("few", 54)));

        System.out.println(myq.poll());
        System.out.println(myq.poll());
        System.out.println(myq.poll());
        System.out.println(myq.poll());
    }

    static void testPalindrome() {
        System.out.println("\n\n[*] Palindrome Testing");
        String arr[] = new String[] {"abbba", "aba", "jjfoelds", "lkkl"};

        for (String str: arr) {
            if(str.equals(new StringBuilder(str).reverse().toString())) {
                System.out.println("Yes: " + str);
            }
            else {
                System.out.println("No: " + str);
            }
        }
    }

    static void testPermutation() {
        System.out.println("\n\n[*] Palindrome Testing");
        String str1 = "ibrar";
        String str2 = "rabir";
        String str3 = "rarbbi";

        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();
        char[] c = str3.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        if(Arrays.equals(a,b)) {
            System.out.println(str1 + " and " + str2 + " are permutations of each other");
        }
        else {
            System.out.println(str1 + " and " + str2 + " are NOT permutations");
        }

        if(Arrays.equals(a,c)) {
            System.out.println(str1 + " and " + str3 + " are permutations of each other");
        }
        else {
            System.out.println(str1 + " and " + str3 + " are NOT permutations");
        }
    }

    static void testJUnit() {
        System.out.println("\n\n[*] JUnit Testing");
        Result result = JUnitCore.runClasses(TestJUnit.class);

        for(Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }

}


