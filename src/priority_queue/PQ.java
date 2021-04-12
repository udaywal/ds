package priority_queue;

import java.util.*;

public class PQ {

    static void PQImplement(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        // for (int a:arr) {
        //     pq.add(a);
        // }
        while (k-- > 0) {
            System.out.print(pq.element());
        }

    }

    public static void main(String[] args) {

        int[] arr = {};
        int k = 1;
        PQImplement(arr, k);

    }
    
}
