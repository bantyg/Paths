import java.util.*;

class PathDB{
	public static Map<String,List<String>> createDB(){
		Map<String,List<String>> flights = new  HashMap<String, List<String>>();
		List<String> banglore = new ArrayList<String>();
		banglore.add("Singapore");
		List<String> singapore = new ArrayList<String>();
		singapore.add("Banglore");
		singapore.add("Seoul");
		singapore.add("Dubai");
		List<String> beijing = new ArrayList<String>();
		beijing.add("Tokyo");
		flights.put("Banglore",banglore);
		flights.put("Singapore",singapore);
		flights.put("Beijing",beijing);
		return flights;
	}
}

class Paths{
	static Map<String,List<String>> data = PathDB.createDB();
	public static boolean findFlight(String source){
		if(data.containsKey(source)){
			return true;
		}
		for (String s :data.keySet()) {
			if(data.get(s).contains(source)) return true;
		}
		return false;
	}

	public static boolean showResult(String src,String dest)throws Exception{
		String[] cities = {src, dest};
		for(String city:cities){
			if(!findFlight(city))
				throw new Exception(city + " City not found");
		}
		if(data.get(src).contains(dest))
			return true;
		return false;
	}

	public static void main(String[] args)throws Exception{
		try{
			System.out.println(showResult(args[0],args[1]));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}













