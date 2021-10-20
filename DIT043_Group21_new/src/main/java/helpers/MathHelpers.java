package helpers;

public class MathHelpers {

    //Tbh i've got this one by searching it on stack overflow , i'm really burned out by now
    public static double TruncateDouble(double value , int decimalPoint){
        value = value * Math.pow(10, decimalPoint);
        value = Math.floor(value);
        value = value / Math.pow(10, decimalPoint);
        return value;
    }



}
