package hashtable_map_set;

import java.util.*;

public class FirstUniqueChar {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // passing string
        String str = scanner.next();
        scanner.close();

        char[] strArray = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (int i=0; i<strArray.length; i++) {
            char key = strArray[i];
            if (map.containsKey(key)) {
                map.put(key,map.get(key)+1);
            } else {
                map.put(key,1);
            }
        }

        for (int i=0; i<strArray.length; i++){
            if (map.get(strArray[i]) == 1) {
                System.out.println(strArray[i]);
                break;
            }
        }

    }
    
}
