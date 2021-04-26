/***
 * 
 * Sort Nearly Sorted Array
 * Given a k-sorted array of n elements, 
 * where each element is at most k steps away from its target position as it would have been in an array 
 * that is sorted in ascending order. Write a program to sort the array in O(n log k) time.
 * 
 * ***/

import java.util.*;

public class NearlySortedArray {

    private static void merge(int[] numbers, int start, int mid, int end) {

        /* Dividing the array */
        int leftLength = mid - start + 1;
        int rightLength = end - mid;
        
        int[] L = new int[leftLength];
        int[] R = new int[rightLength];

        for (int i=0; i<leftLength; i++) {
            L[i] = numbers[start + i];
        }
        for (int j=0; j<rightLength; j++) {
            R[j] = numbers[mid+1 + j];
        }

        /* Sorting of divided array in decending order */
        // creating pointers
        int l=0; 
        int r=0;
        int k=start; 

        while (l<leftLength && r<rightLength) {
            if (L[l] <= R[r]) {
                numbers[k] = L[l];
                l++;
            } else {
                numbers[k] = R[r];
                r++;
            }
            k++;
        }

        while (l<leftLength) {
            numbers[k] = L[l];
            l++;
            k++;
        }
        while (r<rightLength) {
            numbers[k] = R[r];
            r++;
            k++;
        }
        
    }

    public static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(arr, start, mid);
            sort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void sortArray(int[] arr, int k) {

        sort(arr, 0, arr.length-1);
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();

        sortArray(arr, k);
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}