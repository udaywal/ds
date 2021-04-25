package graph;

import java.util.*;

public class GraphOrTree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		int vertices = scanner.nextInt();
        int numberOfEdges = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<vertices; i++) {
            int degreeOfEdge = scanner.nextInt();
            map.put(i, degreeOfEdge);
            numberOfEdges = numberOfEdges + degreeOfEdge;
        }
        System.out.println(numberOfEdges);
        scanner.close();

        if (numberOfEdges == 2 * (vertices-1)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    
}
