package hashtable;

import java.util.*;

public class Anagram {

    public static void main(String[] x){
		Map<String,String> map = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String key;
		String value;
		for(int i = 1; i <= num; i++){
			key = sc.next();
			value = sc.next();
			map.put(key,value);
		}
        sc.close();
		Set<String> keys = map.keySet();
        Stack<Character> stack = new Stack<Character>();
        boolean isNoAnagram = true;
		for (String k:keys) {
		    for (char ch: k.toCharArray()) {
		        stack.push(ch);
		    }
		    String reversekey = "";
		    while (!stack.isEmpty()) {
                reversekey += stack.pop();
            }
            if (reversekey.equals(map.get(k))) {
                System.out.println(k + ":" + map.get(k));
                isNoAnagram = false;
            }
		}
        if (isNoAnagram) {
            System.out.println(false);
        }
	}
    
}
