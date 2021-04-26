/**
 * Find Itinerary in Order
 * Given a list of tickets in pairs as source city and destination city, find the itinerary in order using the given list.
 * 
 * **/

import java.util.*;

public class Source {

    public static void findItinerary(Map<String, String> tickets) {
        Set<String> set = new HashSet<>(tickets.values());
        String itinerary = "";
        String temp = "";
        for (Map.Entry<String, String> m : tickets.entrySet()) {
            if (!set.contains(m.getKey())) {
                temp = temp + m.getValue();
                itinerary = itinerary + m.getKey() + " " + temp;
                break;
            }
        }
        for (int i=0; i<tickets.size(); i++) {
            if (tickets.get(temp) != null) {
                itinerary = itinerary + " " + tickets.get(temp);
                temp = tickets.get(temp);
            }
        }
        System.out.print(itinerary);
    }

    public static void main(String[] args) {
        Map<String, String> tickets = new HashMap<String, String>();
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            tickets.put(sc.next(),sc.next());
        }
        sc.close();
        findItinerary(tickets);
    }
}