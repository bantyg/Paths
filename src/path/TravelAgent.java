package path;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class TravelAgent {
    PathDB db = new PathDB();
    public Map<String,List<String>> data = db.createDB();
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
        return data.get(src).contains(dest);
    }

    public boolean isThereAnyFlightAvailable(List<String> path,String src,String dest)throws Exception{
        isCityPresent(src, dest);
        if(!path.contains(src)) path.add(src);
        if(data.get(src).contains(dest)){
            path.add(dest);
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

    void reverseCities(String src,String dest){
        String temp = src;
        src = dest;
        dest = temp;
    }

    private void isCityPresent(String src, String dest) throws Exception {
        String[] cities = {src,dest};
        for(String city:cities){
            if(!isCity(city))
                throw new Exception(city+" city not found");
        }
    }

    public void findAllPaths(List<List<String>> allPath,List<String> path,String src,String dest)throws Exception{
        path.add(src);
        if(src.equals(dest)){
            allPath.add(new ArrayList<String>(path));
            path.remove(src);
            return;
        }
        for (String city:data.get(src)){
            if(!path.contains(city))
                findAllPaths(allPath, path, city, dest);
        }
        path.remove(src);
    }

    public List<List<String>> getPaths(String src,String dest) throws Exception{
        List<List<String>> allPath= new ArrayList<List<String>>();
        List<String> path = new ArrayList<String>();
        if(isThereAnyFlightAvailable(path,src,dest)){
            findAllPaths(allPath,new ArrayList<String>(),src,dest);
        }
        return allPath;
    }
}
