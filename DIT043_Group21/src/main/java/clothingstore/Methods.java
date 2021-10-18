package clothingstore;

public class Methods {

    public double truncateValue (double input, int precision) {
        input = input * Math.pow(10.0, 2.0);
        int newValue = (int)input;
        return (double)newValue / Math.pow(10.0, 2.0);
    }
}
