import java.util.*;

class PathDB{
	public static Map<String,List<String>> createDB(){
		Map<String,List<String>> flights = new  HashMap<String, List<String>>();
		List<String> banglore = new ArrayList<String>();
		banglore.add("Singapore");
		List<String> singapore = new ArrayList<String>();
		singapore.add("Seoul");
		singapore.add("Dubai");
		List<String> beijing = new ArrayList<String>();
		beijing.add("Tokyo");
		List<String> seoul = new ArrayList<String>();
		seoul.add("Beijing");
		List<String> dubai = new ArrayList<String>();
		dubai.add("Finland");
		flights.put("Banglore",banglore);
		flights.put("Singapore",singapore);
		flights.put("Beijing",beijing);
		flights.put("Dubai",dubai);
		flights.put("Seoul",seoul);
		return flights;
	}
}

class TravelAgent{
	public static Map<String,List<String>> data = PathDB.createDB();
	public static List<List<String>> countries;
	static List<String> path = new ArrayList<String>();
	public static boolean isCity(String source){
		if(data.containsKey(source)){
			return true;
		}
		for (String s :data.keySet()) {
			if(data.get(s).contains(source)) return true;
		}
		return false;
	}

	public static boolean hasFlightAvailable(String src,String dest)throws Exception{
		String[] cities = {src, dest};
		for(String city:cities){
			if(!isCity(city))
				throw new Exception(city + " City not found");
		}
		if(data.get(src).contains(dest))
			return true;
		return false;
	}

	public static void giveCountry(String city){
		List<List<String>> all = Spikes.citiess;
		System.out.println(all);
	}

	public static boolean isThereAnyFlightAvailable(String src,String dest)throws Exception{
		String[] cities = {src,dest};
		for(String city:cities){
			if(!isCity(city))
				throw new Exception(city+" city not found");
		}
		if(data.get(src) == null){
			System.out.println("false");
			return false;	
		}
		if(path.contains(src) == false){path.add(src);}
		if(data.get(src).contains(dest)){
			path.add(dest);
			return true;
		}
		for (String citi:data.get(src)) {
			if(data.get(citi) != null ){
				if (isThereAnyFlightAvailable(citi,dest)==true)
					return true;
 			}
		}
		return false;
	}
}

class Paths{
	public static void main(String[] args)throws Exception{
		try{
			TravelAgent.isThereAnyFlightAvailable(args[0],args[1]);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
}














