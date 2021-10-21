package helpers;

public class MathHelpers {

    public static double truncateDouble(double value){
        int truncatedValue = (int)(value*100);
        //String correctTruncation = String.format("%.2f SEK", newValue);
        return truncatedValue / 100.;
    }
}
