package path;

import java.util.*;
import java.io.*;

public class PathReader{
	public  Map<String,List<String>> readData(String f)throws Exception{
		try{
			File file = new File(f);
		   	Map<String,List<String>> roots = new HashMap<String,List<String>>();
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line ="";
			while((line = in.readLine()) != null){
				String[] places = line.split(",");
				List<String> destinations = new ArrayList<String>();
				for (int i=1;i<places.length ;i++ ) {
                    destinations.add(places[i]);
				}
                if(roots.containsKey(places[0])){
                    roots.get(places[0]).add(destinations.get(0));
                }else
                    roots.put(places[0],destinations);
			}
            return roots;
		}catch(Exception e){
			throw new Exception("Error: "+f+" file not found");
		}
	}


	public List<List<String>> readCities(String option,String f)throws Exception{
		try{
	        List<List<String>> cities = new ArrayList<List<String>>();
	        File file = new File(f);
	        BufferedReader in = new BufferedReader(new FileReader(file));
	        String line ="";
	        while((line = in.readLine()) != null){
	            String[] places = line.split(",");
	            List<String> destinations = new ArrayList<String>();
	            for (int i=0;i<places.length ;i++ ) {
	                destinations.add(places[i]);
	            }
	            cities.add(destinations);
	        }
	        return cities;
	    }catch(Exception e){
			throw new Exception("Error: "+f+" file not found");
		}
    }

    public List<String> addCountries(String places,List<List<String>> countries){
        String[] splitted = places.split("->");
        List<String> output = new ArrayList<String>();
        for (String city :splitted ) {
            for (List<String> l :countries ) {
                if(city.equals(l.get(0)) == true){
                    city = city+"["+l.get(1)+"]";
                    output.add(city);
                }
            }
        }
        return output;
    }


}