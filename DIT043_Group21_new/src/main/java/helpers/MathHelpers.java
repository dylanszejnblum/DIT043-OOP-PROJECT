package helpers;

public class MathHelpers {

    //Tbh i've got this one by searching it on stack overflow , i'm really burned out by now

    public static double TruncateDouble(double value , int decimalPoint){
        int truncatedValue = (int)(value*100);
        double newValue = truncatedValue / 100.00;
        String correctTruncation = String.format("%.2f SEK", newValue);
        return(Double.parseDouble(correctTruncation));
    }



}
