package path;

import java.util.*;
import java.io.*;

public class PathReader{
	public static Map<String,List<String>> readData(String f)throws Exception{
		try{
			File file = new File(f);
		   	Map<String,List<String>> roots = new HashMap<String,List<String>>();
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line ="";
			while((line = in.readLine()) != null){
				String[] cities = line.split(",");
				List<String> destinations = new ArrayList<String>();
				for (int i=1;i<cities.length ;i++ ) {
					destinations.add(cities[i]);
				}
				roots.put(cities[0],destinations);
			}
			return roots;
		}catch(Exception e){
			throw new Exception("Error: "+f+" file not found");
		}
	}


	public static List<List<String>> readCities(String option,String f)throws Exception{
		try{
	        List<List<String>> citiess = new ArrayList<List<String>>();
	        File file = new File(f);
	        BufferedReader in = new BufferedReader(new FileReader(file));
	        String line ="";
	        while((line = in.readLine()) != null){
	            String[] cities = line.split(",");
	            List<String> destinations = new ArrayList<String>();
	            for (int i=0;i<cities.length ;i++ ) {
	                destinations.add(cities[i]);
	            }
	            citiess.add(destinations);
	        }
	        return citiess;
	    }catch(Exception e){
			throw new Exception("Error: "+f+" file not found");
		}
    }

    public static List<String> addCountries(String cities,List<List<String>> countries){
        String[] splitted = cities.split("->");
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