package hashtable_map_set;

import java.util.Set;
import java.util.TreeSet;

/**
 * If the given array of integers and the target sum are {1, 7, 40, 8, -7, 3} and 15, 
 * respectively, then check whether a pair with the sum equal to the given target sum exists or not. 
 * The output should be ‘true’ because 7 and 8 are the pair of integers from the given array of integers 
 * whose sum is equal to the given target sum 15.
 * 
 * **/

public class PairWithGivenSum {

    public static void main(String[] args) {
        
        int[] array = {1, 7, 40, 8, -7, 3};
        Set<Integer> set = new TreeSet<Integer>(); 

        int target = 15;
        boolean isSumExist = false;

        for (int i=0; i<array.length; i++) {
            set.add(array[i]);
        }

        for (int i=0; i<array.length; i++) {
            if (set.contains(target - array[i])) {
                // System.out.print(array[i]);
                // System.out.print(target - array[i]);
                isSumExist = true;
                break;
            }
        }
        System.out.print(isSumExist);

    }
    
}
