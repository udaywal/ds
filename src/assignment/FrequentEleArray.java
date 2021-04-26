import java.util.*;

public class FrequentEleArray {

    public static int mostFrequentElement(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int a:arr) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }
        int temp = arr[0];
        for (int a:map.keySet()) {
            if (map.get(a) > map.get(temp)) {
                temp = a;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        if (arr.length > 0) {
            System.out.println(mostFrequentElement(arr));
        } else {
            System.out.println(-1);
        }
    }

}
