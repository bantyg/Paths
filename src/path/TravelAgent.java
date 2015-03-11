package path;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class TravelAgent {
    PathDB db = new PathDB();
    public Map<String,List<String>> data = db.createDB();
    List<List<String>> allPath= new ArrayList<List<String>>();
    List<String> path = new ArrayList<String>();
    public boolean isCity(String source){
        if(data.containsKey(source)){
            return true;
        }
        for (String s :data.keySet()) {
            if(data.get(s).contains(source)) return true;
        }
        return false;
    }

    public boolean hasFlightAvailable(String src,String dest)throws Exception{
        String[] cities = {src, dest};
        for(String city:cities){
            if(!isCity(city))
                throw new Exception(city + " City not found");
        }
        if(data.get(src).contains(dest)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isThereAnyFlightAvailable(List<String> path,String src,String dest)throws Exception{

        String[] cities = {src,dest};
        for(String city:cities){
            if(!isCity(city))
                throw new Exception(city+" city not found");
        }
        if(data.get(src) == null){
            return false;
        }
        if(!path.contains(src)){path.add(src);}
        if(data.get(src).contains(dest)){
            path.add(dest);
            allPath.add(path);
            System.out.println(allPath);
            return true;
        }
        for (String citi:data.get(src)) {
            if(data.get(citi) != null ){
                if (isThereAnyFlightAvailable(path,citi,dest))
                    return true;
            }
        }
        return false;
    }

    public List<String> showReversePath(List<String> cities){
        List<String> reverse = new ArrayList<String>();
        int j = 0;
        for (int i=cities.size()-1;i>=0;i--){
            reverse.add(j,cities.get(i));
            j++;
        }
        return reverse;
    }
}
