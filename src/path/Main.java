package path;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try{
            List<List<String>> cityWithCountry = PathReader.readCities(args[2], args[3]);
            TravelAgent.data = PathReader.readData( args[1]);
            TravelAgent.isThereAnyFlightAvailable(args[4], args[5]);
            List<String> pathList = PathReader.addCountries(String.join("->",TravelAgent.path),cityWithCountry);
            String path = String.join("->",pathList);
            System.out.println(path);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
