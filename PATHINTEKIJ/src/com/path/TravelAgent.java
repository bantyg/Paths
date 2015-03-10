package com.path;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by poojag on 3/7/2015.
 */
public class TravelAgent {
    static Map<String,List<String>> data = PathDB.createDB();
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
        if(!path.contains(src)){path.add(src);}
        if(data.get(src).contains(dest)){
            path.add(dest);
            // System.out.println(path);
            return true;
        }
        for (String citi:data.get(src)) {
            if(data.get(citi) != null ){
                if (isThereAnyFlightAvailable(citi,dest))
                    return true;
            }
        }
        return false;
    }

    public static List<String> showReversePath(List<String> cities){
        List<String> reverse = new ArrayList<String>();
        int j = 0;
        for (int i=cities.size()-1;i>=0;i--){
            reverse.add(j,cities.get(i));
            j++;
        }
        return reverse;
    }
}
