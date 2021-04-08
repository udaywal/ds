package hashtable;

import java.util.*;

public class MatchLocksKeys {

    public static void main(String[] args) {

        char[] keys = {'#', '%', '!', '@', '$'};
        char[] locks = {'!', '@', '#', '$', '%'};

        Map<Character, Integer> lockMap = new HashMap<>();
        Map<Character, Character> map = new LinkedHashMap<>();
        Boolean possible = true;

        for (int i=0; i<locks.length; i++) {
            lockMap.put(locks[i], i);
        }
        for (int j=0; j<keys.length; j++) {
            if (lockMap.get(keys[j]) != null) {
                map.put(keys[j], locks[lockMap.get(keys[j])]);
            } else {
                possible = false;
                break;
            }
        }
        if (possible) {
            for (Map.Entry<Character, Character> m : map.entrySet()) {
                System.out.println(m.getKey() + " " + m.getValue());
            }
        } else {
                System.out.println("Not possible");
        }

    }
    
}
