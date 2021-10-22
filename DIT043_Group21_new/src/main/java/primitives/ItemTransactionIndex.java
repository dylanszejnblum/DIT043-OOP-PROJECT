package primitives;

public class ItemTransactionIndex {
    public String ID ;
    public double profit;

    public ItemTransactionIndex(String ID , double profit){
        this.ID = ID;
        this.profit = profit;
    }

    public String getID(){
        return this.ID;
    }
    public double getProfit(){
        return this.profit;
    }

}
