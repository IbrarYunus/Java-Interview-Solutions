package com.none;

import java.util.*;

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
        testWordFrequency();
        testArraysAndString();
        testLinkedLists();
        testStacks();
        testRecursion();
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

    static void testWordFrequency() {
        System.out.println("\n\n[*] Word Frequency Testing");
        String word = "this";
        String arr[] = new String[]{"this", "that", "THIS", "those", "him"};
        MediumProblems mp = new MediumProblems();
        mp.wordFrequency(arr, word);
    }

    static void testArraysAndString() {
        System.out.println("\n\n[*] String and Arrays Testing");
        ArraysAndStringProblems asp = new ArraysAndStringProblems();
        asp.URLify("This is a new test String");
        asp.palindromPermutation("aabbc");
    }

    static void testLinkedLists() {
        System.out.println("\n\n[*] LinkedList Testing");
        Random rand = new Random();

        int total = 10;
        LinkedListNode head = new LinkedListNode(53);
        LinkedListNode prev = head;
        for (int i=0; i< total; i++) {
            LinkedListNode temp = new LinkedListNode(rand.nextInt(9) + 1);
            temp.setPrevious(prev);
            prev = temp;
        }

        LinkedListNode temp = head;
        while(temp.next != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        LinkedListProblems llp = new LinkedListProblems();

        llp.KthToLastElement(head, 6);

        llp.removeDuplicates(head);


        temp = head;
        while(temp.next != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }

    static void testStacks() {
        System.out.println("\n\n[*] Stacks Testing");
        Dog d1 = new Dog("first");
        Dog d2 = new Dog("second");
        Cat c1 = new Cat("third");
        Dog d3 = new Dog("fourth");

        AnimalQueue aq = new AnimalQueue();
        aq.enqueue(d1);
        aq.enqueue(d2);
        aq.enqueue(c1);
        aq.enqueue(d3);

        System.out.println("poll 1: " + aq.dequeueCats().name);
    }

    static void testRecursion() {
        System.out.println("\n\n[*] Recursion Testing");
        int steps = 25;
        int arr [] = new int[] {5,6,2,6,3,1,7,8,3,5,6};
        Arrays.sort(arr);
        RecursionProblems rp = new RecursionProblems();

        System.out.println("Recursion: Number of Ways to climb " + steps + " steps: " + rp.countWays(steps));
        System.out.println("Memoization: Number of Ways to climb " + steps + " steps: " + rp.countWaysMamoization(steps));
        System.out.println("Magic Index: " + rp.magicFast(arr));
    }
}


