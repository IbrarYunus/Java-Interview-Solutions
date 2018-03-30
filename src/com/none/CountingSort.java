package com.none;

import java.util.Arrays;

public class CountingSort {

    void sort(char arr[]) {
        int n = arr.length;
        char output[] = new char[n];

        int count[] = new int[256];

        for(int i = 0; i< 256; ++i) {
            count[i] = 0;
        }

        for(int i = 0; i < n; ++i) {
            ++count[arr[i]];
        }

        for(int i = 1; i <= 255; ++i) {
            count[i] += count[i -1];
        }

        for(int i = 0; i < n; ++i) {
            output[count[arr[i]] -1] = arr[i];
            --count[arr[i]];
        }

        for(int i = 0; i<n; ++i) {
            arr[i] = output[i];
        }
    }

    int getMax(int arr[], int n) {
        int mx =  arr[0];
        for(int i = 0; i < n; ++i) {
            if(arr[i] > mx) {
                mx = arr[i];
            }
        }
        return mx;
    }

    void countingSort(int arr[], int n, int exp) {
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for(i = 0; i < n; i++) {
            count[(arr[i]/exp)%10]++;
        }

        for(i = 1; i < 10; i++) {
            count[i] += count[i-1];
        }

        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i]/exp)%10] -1] = arr[i];
            count[ (arr[i]/exp)%10]--;
        }

        for(i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    void radixsort(int arr[], int n) {
        int m = getMax(arr, n);

        for (int exp = 1; m/exp > 0; exp *= 10) {
            countingSort(arr, n , exp);
        }
    }

    void print(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
