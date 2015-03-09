import java.util.*;
import java.io.*;
class Path{

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
		System.out.println(roots);
		return roots;
	}
	public static void main(String[] args)throws Exception{
		try{

			System.out.println("----------"+	readData(args[0],args[1]));
		}
		catch(Exception e){}
	}
}


