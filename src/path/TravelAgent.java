package path;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class TravelAgent {
    PathDB db = new PathDB();
    public Map<String,List<String>> data = db.createDB();

    public boolean isCity(String source){
        if(data.containsKey(source)) return true;
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

    public boolean isThereAnyFlightAvailable(List<String> path,String src,String destination)throws Exception{
        isCityPresent(src, destination);
        if(data.get(src) == null){return false;}
        if(!path.contains(src)) path.add(src);
        if(data.get(src).contains(destination)){
            path.add(destination);
            return true;
        }
        for (String city:data.get(src)) {
                if (getCityForFindingPath(path, destination, city)) return true;
        }
        return false;
    }

    private boolean getCityForFindingPath(List<String> path, String destination, String city) throws Exception {
        if(data.get(city) != null ){
            if (isThereAnyFlightAvailable(path,city,destination))
                return true;
        }
        return false;
    }

    private void isCityPresent(String src, String destination) throws Exception {
        String[] cities = {src,destination};
        for(String city:cities){
            if(!isCity(city))
                throw new Exception(city+" city not found");
        }
    }

    public void findAllPaths(List<List<String>> allPath,List<String> path,String src,String destination)throws Exception{
        path.add(src);
        if(src.equals(destination)){
            allPath.add(new ArrayList<String>(path));
            path.remove(src);
            return;
        }
        for (String city:data.get(src)){
            if(!path.contains(city))
                findAllPaths(allPath, path, city, destination);
        }
        path.remove(src);
    }

    public List<List<String>> getPaths(String src,String destination) throws Exception{
        List<List<String>> allPath= new ArrayList<List<String>>();
        List<String> path = new ArrayList<String>();
        if(isThereAnyFlightAvailable(path,src,destination)){
            findAllPaths(allPath,new ArrayList<String>(),src,destination);
        }
        return allPath;
    }
}
