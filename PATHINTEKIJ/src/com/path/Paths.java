package com.path;

/**
 * Created by poojag on 3/7/2015.
 */
public class Paths {
    public static void main(String[] args)throws Exception{
        try{
            TravelAgent.isThereAnyFlightAvailable(args[0],args[1]);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
