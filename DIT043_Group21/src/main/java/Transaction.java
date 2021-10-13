public class Transaction {

    public Items items = new Items();
    public Item item;

    private double profit;
    private int unitsSold;
    private String ID;
    private double totalProfit;
    private int totalUnitsSold;

    public Transaction( String ID, double profit, int unitsSold) {
        this.profit = profit;
        this.unitsSold = unitsSold;
        this.ID = ID;
    }

    public double getProfit() {
        return profit;
    }

    public int getUnitsSold() {
        return unitsSold;
    }

    public String getID() {
        return ID;
    }

    public double getTotalProfit() {
        return totalProfit;
    }

    public int getTotalUnitsSold() {
        return totalUnitsSold;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public void setUnitsSold(int unitsSold) {
        this.unitsSold = unitsSold;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setTotalProfit(double totalProfit) {
        this.totalProfit = totalProfit;
    }

    public void setTotalUnitsSold(int totalUnitsSold) {
        this.totalUnitsSold = totalUnitsSold;
    }

    public double getTotalProfit(Item item) {
        for (Transaction transaction : item.transactionList) {
            totalProfit += transaction.getProfit();
        }

        return totalProfit;
    }

    public int getTotalUnitsSold(Item item) {
        for (Transaction transaction : item.transactionList) {
            totalUnitsSold += transaction.getUnitsSold();
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
    public String printTransactionsItem(String ID){
        String result = "";
        Item item = Items.GetItemByID(ID);
        if (item == null){
            return "Item " + ID + " was not registered yet.";
        }

        else if (item.transactionList.isEmpty()){
            return "Transactions for item: " + ID +": " + item.GetName() + ". " + item.GetPrice() + " SEK \n "+
                    "No transactions have been registered for item " + ID + " yet.";
        }
        for (Transaction currentTransaction : item.transactionList){
            result += "Transactions for item:"+ ID+ ": " + item.GetName() +". "+ item.GetPrice()+ "SEK + \n";
            result += currentTransaction.getID() + ": " + currentTransaction.getUnitsSold() + " item(s). " + item.GetPrice() + " SEK + \n";

        }
        return result;
    }

    //4.4 - Oscar
    /*
    public String retrieveDataAllTransactions (String ID){

    }

     */


}
