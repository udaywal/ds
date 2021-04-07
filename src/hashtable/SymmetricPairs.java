package hashtable;

import java.util.*;

public class SymmetricPairs {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // number of pairs in the array
        int n = scanner.nextInt();
        int arr[][] = new int[n][2];

        // store the input pairs to an array "arr"
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }
        scanner.close();

        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        Boolean isAnySymmetric = false;

        for (int i=0; i<arr.length; i++) {
            int first = arr[i][0];
            int second = arr[i][1];
            Integer value = map.get(second);
            if (value != null && first == value) {
                System.out.println(second + " " + first);
                isAnySymmetric = true;
            } else {
                map.put(first,second);
            }
        }

        if (!isAnySymmetric) {
            System.out.println("No Symmetric pair");
        }

    }
    
}
