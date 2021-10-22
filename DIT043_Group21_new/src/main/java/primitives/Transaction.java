package primitives;

import java.text.DecimalFormat;

public class Transaction {
    String ID;
    int amount;
    double price;

    public Transaction(String ID , int amount, double price){

            this.ID = ID;
            this.amount = amount;
            this.price = price;

    }
    public String getId(){
        return this.ID;
    }
    public int getAmount(){return this.amount;}
    public double getPrice(){return this.price;}
    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("0.00");

        return this.ID + ": " + this.amount +  " item(s). " + df.format(this.price) + " SEK"  ;
    }

}
