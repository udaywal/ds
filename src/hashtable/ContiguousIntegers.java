package hashtable;

import java.util.*;

class ContiguousIntegers {

    public static void main(String[] args) {

        Set<Integer> tSet = new TreeSet<>();
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();
 
        //array to store the input elements
        int[] array = new int[n];
    
        //storing the elements to the array
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
            tSet.add(array[i]);
        }
        in.close();

        Integer arr[] = new Integer[tSet.size()];

        arr = tSet.toArray(arr);

        if ((arr[arr.length -1] - arr[0])+1 == (arr.length)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

    }
}
