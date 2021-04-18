package priority_queue;

import java.util.Scanner;

class IsMaxHeap {

    public static boolean isMaxHeap(int[] arr, int n) {
        if (2*n + 2 < arr.length) {
            return true;
        }
        // recursively check if the left child is a heap
        boolean left = (arr[n] >= arr[2*n + 1]) && isMaxHeap(arr, 2*n + 1);
        // recursively check if the right child is a heap (to avoid the array index out
        // of bounds, first check if the right child exists or not)
        boolean right = (2*n + 2 == arr.length) ||
                        (arr[n] >= arr[2*n + 2] && isMaxHeap(arr, 2*n + 2));
        // return true if both left and right child are heaps
        return left && right;
    }

    public static int[] getArrayInput(int size, Scanner scanner) {
        int array[] = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeArray1 = scanner.nextInt();
        int arr[] = getArrayInput(sizeArray1, scanner);
        int n = arr.length;
        String x = isMaxHeap(arr, n) ? "Yes" : "No";

        System.out.println(x);
    }

}
