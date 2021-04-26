/**
 * Given an infinite stream of integers, find the kth largest element at any point in time.
 * Hint: If you keep the stream sorted somehow at all times, it becomes easier to detect the kth largest number at any given point in time.
 * 
 * Input Format:
 * 
 * The first line contains an integer ‘N’ as the size of the stream.
 * The second line contains an integer ‘K’ representing the position of the largest number.
 * The third line contains elements of the stream of size ‘N’.
 * 
 * Output Format:
 * 
 * The output contains the kth largest number at any point in time. If the kth largest number does not exist, then print ‘None’ (without quotes and with capital letter ‘N’). 
 * 
 * Sample Test Cases:
 * 
 * Input:
 * 8
 * 3
 * 20 30 21 80 60 50 110 15
 * 
 * Output:
 * None
 * None
 * 3 largest number is 20
 * 3 largest number is 21
 * 3 largest number is 30
 * 3 largest number is 50
 * 3 largest number is 60
 * 3 largest number is 60
 * 
 * **/

import java.util.*;

public class KthLargestStream {

    public PriorityQueue<Integer> pq;
    
    public KthLargestStream (int k, int[] nums) {
        pq = new PriorityQueue<>();
        for (int num : nums) {
            add(num, k);
        }
    }
    
    public int add(int num, int k) {
        if (pq.size() < k) {
            pq.add(num);
        } else if (pq.peek() < num) {
            pq.poll();
            pq.add(num);
        }
        int km = pq.peek();
        if (pq.size() < k) {
            System.out.println("None");
        } else {
            System.out.println(k + " largest number is " + km);
        }
        return km;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int stream[] = new int[n];
        for (int i = 0; i < n; i++) {
            stream[i] = sc.nextInt();
        }
        sc.close();
        new KthLargestStream(k,stream);
    }
    
}