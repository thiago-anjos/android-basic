package utils;

public class CalculateFuel {
    public static String mensagem(){
        return "Hello";
    }

    public static String CalculateFuelBestOption(double gasoline, double ethanol){
        double bestPrice = gasoline * 0.70;
        String message;

        if(ethanol < bestPrice){
            message = "ETANOL";
        }else{
            message = "GASOLINA";
        }
        return message;
    }

}
