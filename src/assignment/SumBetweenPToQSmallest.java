/***
 * 
 * Find Sum Between pth and qth Smallest Elements
 * 
 * Given an array and two numbers p and q, 
 * Find the sum of all the elements of the array such that the range of the elements is between the pth and qth smallest elements of the array.
 * For example, consider an array arr[] = {30, 18, 32, 14, 22, 20, 24}.
 * 
 * Let's assume that p is equal to 3 and q is equal to 6. 
 * Now the third-smallest element in the array is 20 and the sixth-smallest element is 30. 
 * Therefore, you will calculate the sum of all the elements greater than 20 and less than 30 in the array. 
 * Hence, the required sum is 22 + 24 = 46 .
 * 
 * ***/

import java.util.*;

public class SumBetweenPToQSmallest {

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

    public static int sumBetweenPthToQthSmallestElement(int[] arr, int p, int q) {
        sort(arr, 0, arr.length-1);
        int total = 0;
        for (int i=p; i<q-1; i++) {
            total = total + arr[i];
        }
        return total;
     }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int p = sc.nextInt();
        int q = sc.nextInt();
        sc.close();
        System.out.println(sumBetweenPthToQthSmallestElement(arr, p, q));
    }
}
// 14 18 20 22 24 30 32