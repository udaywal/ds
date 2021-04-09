package hashtable_map_set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * You will be given the source and destination of all the tickets in the form of a map, 
 * and you have to print the itinerary from all those tickets.
 * Note: 
 * The path covered by the tickets is not circular. 
 * Other than the final destination, there is exactly one ticket from every city.
 * 
*/

public class ItineraryTickets {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();

        map.put("Mumbai", "Indore");
        map.put("Hyderabad", "Warangal");
        map.put("Indore", "Hyderabad");
        map.put("Delhi", "Mumbai");

        Set<String> set = new HashSet<>(map.values());

        String itinerary = "";
        String temp = "";

        // Iterate over the map
        for (Map.Entry<String, String> m : map.entrySet()) {
            if (!set.contains(m.getKey())) {
                temp = temp + m.getValue();
                itinerary = itinerary + m.getKey() + " " + temp;
                break;
            }
        }

        for (int i=0; i<map.size(); i++) {
            if (map.get(temp) != null) {
                itinerary = itinerary + " " + map.get(temp);
                temp = map.get(temp);
            }
        }

        System.out.print(itinerary);

    }
    
}
