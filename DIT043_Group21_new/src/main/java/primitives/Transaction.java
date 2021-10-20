package primitives;

public class Transaction {
    String ID;
    int amount;
    double price;

    public Transaction(String ID , int amount, double price){

            this.ID = ID;
            this.amount = amount;
            this.price = price;

    }

    @Override
    public String toString(){
        return this.ID + ": " + this.amount + "  item(s). "+ this.price+" SEK";
    }

}
