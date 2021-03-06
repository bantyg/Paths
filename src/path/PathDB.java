package path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PathDB {
    public Map<String,List<String>> createDB(){
        Map<String,List<String>> flights = new HashMap<String, List<String>>();
        List<String> bangalore = new ArrayList<String>();
        bangalore.add("Singapore");
        List<String> singapore = new ArrayList<String>();
        singapore.add("Seoul");
        singapore.add("Dubai");
        List<String> beijing = new ArrayList<String>();
        beijing.add("Tokyo");
        List<String> seoul = new ArrayList<String>();
        seoul.add("Beijing");
        List<String> dubai = new ArrayList<String>();
        dubai.add("Finland");
        flights.put("Bangalore",bangalore);
        flights.put("Singapore",singapore);
        flights.put("Beijing",beijing);
        flights.put("Dubai",dubai);
        flights.put("Seoul",seoul);
        return flights;
    }
}
