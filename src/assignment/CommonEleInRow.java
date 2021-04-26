/**
 * 
 * Find All Common Element in All Rows of Matrix
Given an M x N matrix of integers, find all the common elements that are present in all rows of the given matrix in O(M * N) time.

For example, take a look at the matrix given below.

11 12 11 14 18

13 17 18 15 11

18 17 17 13 11

18 11 12 17 19

In this matrix, 11 and 18 appear in each row. Hence, 11 and 18 will be the common elements that are present in each row.
 * 
 * **/

import java.util.*;

public class CommonEleInRow {

    public static void printElementInAllRows(int matrix[][], int row, int col) {
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int j = 0; j < col; j++) {
            map.put(matrix[0][j], 1);
        }
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map.get(matrix[i][j]) != null && map.get(matrix[i][j]) == i) {
                    map.put(matrix[i][j], i + 1);
                    if (i == row - 1) {
                        set.add(matrix[i][j]);
                    }
                }
            }
        }
        while (!set.isEmpty()) {
            System.out.print(set.pollFirst() + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        int matrix[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        sc.close();
        
        printElementInAllRows(matrix, row, col);
    }
}