package clothingstore;

public class Methods {

    public double truncateValue (double input) {
        input = input * Math.pow(10.0, 2.0);
        int newValue = (int)input;
        return newValue / Math.pow(10.0, 2.0);
    }



}
