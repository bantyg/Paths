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
public class Spikes {
    public static List<List<String>> readData(String option,String filee)throws Exception{
        File file = new File(filee);
        List<List<String>> cityAndCountryList = new ArrayList<List<String>>();
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line ="";
        while((line = in.readLine()) != null){
            String[] cities = line.split(",");
            List<String> aa = new ArrayList<String>();
            for (int i=1;i<cities.length ;i++ ) {
                aa.add(cities[i]);
            }
            cityAndCountryList.add(aa);
        }
        return cityAndCountryList;
    }
    public static void main(String[] args)throws Exception{
        try{

            System.out.println(readData(args[0],args[1]));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
