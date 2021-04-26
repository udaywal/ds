/***
 * 
 * Find All Symmetric Pairs in an Array
 * 
 * Given an array of pairs of integers, find all the symmetric pairs in it. 
 * Two pairs (a, b) and (c, d) are said to be symmetric if b is equivalent to c and a is equivalent to d.
 * 
 * For example, (10, 20) and (20, 10) are symmetric. 
 * It may be assumed that the first element in each pair is distinct.
 * 
 * ***/

import java.util.*;

public class SymmetricPair {

    public static void symmetricPair(int[][] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {

            int first = arr[i][0];
            int second = arr[i][1];
            Integer value = hashMap.get(second);
            if (value != null && value == first) {
                System.out.println(second + " " + first);
            } else {
                hashMap.put(first, second);
            }
        }
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int arr[][] = new int[row][2];
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < 2 ; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();
        symmetricPair(arr);
    }
    
}