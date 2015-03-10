package path;


public class Paths {
    public static void main(String[] args)throws Exception{
        try{
            if(TravelAgent.data.get(args[0]) == null && TravelAgent.data.get(args[1]) != null){
                TravelAgent.isThereAnyFlightAvailable(args[0],args[1]);
                System.out.println(TravelAgent.showReversePath(TravelAgent.path));
            }
            else{
                TravelAgent.isThereAnyFlightAvailable(args[0],args[1]);
                System.out.println(TravelAgent.path);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
