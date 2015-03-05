import java.util.*;
import java.io.*;
class Path{
	public static void main(String[] args)throws Exception{
		try{
			File file = new File(args[0]);
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
			System.out.println(roots);
		}
		catch(Exception e){

		}
	}
}


