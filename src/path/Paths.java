package path;


import java.util.ArrayList;
import java.util.List;

public class Paths {
    public static void main(String[] args)throws Exception{
        try{
            TravelAgent agent = new TravelAgent();
                System.out.println(agent.hasFlightAvailable(args[0], args[1]));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
