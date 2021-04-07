package hashtable;

import java.util.Hashtable;
import java.util.Set;

public class HashtableOperations {

    public static void main(String[] args) {

        Hashtable<String,Integer> contacts = new Hashtable<String,Integer>();

        contacts.put("Vaibhav", 1245);
        contacts.put("Prashant", 1244);
        contacts.put("Virendra", 1242);
        contacts.put("Abhinav", 1241);

        /* To check whether the key exists */
        System.out.println(contacts.containsKey("Vaibhav"));

        /* To extract all keys in a Set */
        Set<String> keys = contacts.keySet();

        for (String key: keys) {
            System.out.println(contacts.get(key));
        }

        /* To remove the key-value pair from the hashtable */
        contacts.remove("Vaibhav");

        System.out.println(contacts.containsKey("Vaibhav"));

        /* To remove the entire hashtable */
        contacts.clear();

        /* To get the size of a hashtable */
        System.out.println(contacts.size());

    }
    
}
