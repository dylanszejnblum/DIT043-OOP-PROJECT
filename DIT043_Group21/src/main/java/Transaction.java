public class Transaction {

    double profit;
    int unitsSold;
    int ID;
    double totalProfit;
    int totalUnitsSold;

    public Transaction( int ID, double profit, int unitsSold) {
        this.profit = profit;
        this.unitsSold = unitsSold;
        this.ID = ID;
    }


    public double getTotalProfit(Item item) {
        for (Transaction transaction : item.transactionList) {
            totalProfit += transaction.profit;
        }

        return totalProfit;
    }

    public int getTotalUnitsSold(Item item) {
        for (Transaction transaction : item.transactionList) {
            totalUnitsSold += transaction.unitsSold;
        }

        return totalUnitsSold;
    }

    public int getNumberOfTransactions(Item item) {
        int numberOfTransactions = item.transactionList.size();

        return numberOfTransactions;
    }

    public void printTransactions(Item item) {

        System.out.println("Transactions for item: "+ item.GetId() + ": " + item.GetName() + ". " + item.GetPrice() + " SEK" );

        for (String transaction : item.transactionStringArray) {

            System.out.println(transaction);
        }
    }

    //4.3 - Oscar
    public String printTransactionsItem(int ID){
        String result = "";
        Item item = GetItemById(ID);
        if (item == null){
            return "Item " + ID + " was not registered yet.";
        }

        else if (item.transactionList.isEmpty()){
            return "Transactions for item: " + ID +": " + item.Name + ". " + item.Price + " SEK \n "+
                    "No transactions have been registered for item " + ID + " yet.";
        }
        for (Transaction currentTransaction : item.transactionList){
            result += "Transactions for item:"+ ID+ ": " + item.Name +". "+ item.Price+ "SEK + \n";
            result += currentTransaction.ID + ": " + currentTransaction.unitsSold + " item(s). " + item.Price + " SEK + \n";

        }
        return result;
    }

    //4.4 - Oscar
    public String retrieveDataAllTransactions (String ID){



    return "";
    }


}
