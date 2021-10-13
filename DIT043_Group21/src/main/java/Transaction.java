public class Transaction{

    double profit;
    int unitsSold;
    int ID;

    public Transaction(int ID, double profit, int unitsSold) {
        this.ID = ID;
        this.profit = profit;
        this.unitsSold = unitsSold;
    }

    public String getTransactionHistory(){

        return "";
    }


    public double getTotalProfit(){


        return 0.0;
    }

    public int getTotalUnitsSold(){

        return 0;
    }

    public int getNumberOfTransactions(){

        return 0;
    }




}
