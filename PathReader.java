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
	public static void main(String[] args)throws Exception{
		try{
			TravelAgent.data = readData(args[0],args[1]);
			TravelAgent.isThereAnyFlightAvailable(args[2],args[3]);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}