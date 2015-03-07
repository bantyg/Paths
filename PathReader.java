import java.util.*;
import java.io.*;

class PathReader{
	public static Map<String,List<String>> readData(String option,String filee)throws Exception{
		File file = new File(filee);
	   	Map<String,List<String>> roots = new HashMap<String,List<String>>();
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line ="";
		while((line = in.readLine()) != null){
			String[] cities = line.split(",");
			List<String> aa = new ArrayList<String>();
			for (int i=1;i<cities.length ;i++ ) {
				aa.add(cities[i]);
			}
			roots.put(cities[0],aa);
		}
		return roots;
	}

	public static List<List<String>> readCities(String option,String filee)throws Exception{
    	List<List<String>> citiess = new ArrayList<List<String>>();
        File file = new File(filee);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line ="";
        while((line = in.readLine()) != null){
            String[] cities = line.split(",");
            List<String> aa = new ArrayList<String>();
            for (int i=0;i<cities.length ;i++ ) {
                aa.add(cities[i]);
            }
            citiess.add(aa);
        }
        return citiess;
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

	public static void main(String[] args)throws Exception{
		try{
			List<List<String>> cityWithCountry = readCities(args[2],args[3]);
			TravelAgent.data = readData(args[0],args[1]);
			TravelAgent.isThereAnyFlightAvailable(args[4],args[5]);
			List<String> pathList = addCountries(String.join("->",TravelAgent.path),cityWithCountry);
			String path = String.join("->",pathList);
			System.out.println(path);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}