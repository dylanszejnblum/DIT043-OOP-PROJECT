package clothingstore;

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

    public double getTotalProfitItem() {
        return totalProfit;
    }

    public int getTotalUnitsSoldItem() {
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

    public void setTotalUnitsSoldItem(int totalUnitsSold) {
        this.totalUnitsSold = totalUnitsSold;
    }

    //method for getting the profit of all transactions
    public double getTotalProfit(){
        double profitOfAllPurchases = 0.0;
        for (Item item : items.itemList) {
            for (Transaction currentTransaction :item.transactionList) {
                profitOfAllPurchases += currentTransaction.getProfit();
            }
        }
        return profitOfAllPurchases;
    }

    //method for getting the units sold of all the transactions made till the moment.
    public int getTotalUnitsSold(){
        int unitsSoldOfAllPurchases = 0;
        for (Item item : items.itemList) {
            for (Transaction currentTransaction :item.transactionList) {
                unitsSoldOfAllPurchases += currentTransaction.getProfit();
            }
        }
        return unitsSoldOfAllPurchases;
    }

    //method for getting the all the transactions made till the moment.
    public int getTotalTransactions(){
        int totalTransactions = 0;
        for (Item item : items.itemList) {
            for (Transaction currentTransaction :item.transactionList) {
                totalTransactions += currentTransaction.getProfit();
            }
        }
        return totalTransactions;
    }


    public double getTotalProfitItem(Item item) {
        for (Transaction transaction : item.transactionList) {
            totalProfit += transaction.getProfit();
        }

        return totalProfit;
    }

    public int getTotalUnitsSoldItem(Item item) {
        for (Transaction transaction : item.transactionList) {
            totalUnitsSold += transaction.getUnitsSold();
        }

        return totalUnitsSold;
    }

    public int getNumberOfTransactionsItem(Item item) {
        int numberOfTransactions = item.transactionList.size();

        return numberOfTransactions;
    }

    public void printTransactionsItem(Item item) {

        System.out.println("Transactions for item: "+ item.getId() + ": " + item.getName() + ". " + item.getPrice() + " SEK" );

        for (String transaction : item.transactionStringArray) {

            System.out.println(transaction);
        }
    }

    //4.3 - Oscar
    public String printTransactionsItem(String ID){
        String result = "";
        Item item = items.getItemByID(ID);
        if (item == null){
            return "Item " + ID + " was not registered yet.";
        }

        else if (item.transactionList.isEmpty()){
            return "Transactions for item: " + ID +": " + item.getName() + ". " + item.getPrice() + " SEK \n "+
                    "No transactions have been registered for item " + ID + " yet.";
        }
        for (Transaction currentTransaction : item.transactionList){
            result += "Transactions for item:"+ ID+ ": " + item.getName() +". "+ item.getPrice()+ "SEK + \n";
            result += currentTransaction.getID() + ": " + currentTransaction.getUnitsSold() + " item(s). " + item.getPrice() + " SEK + \n";

        }
        return result;
    }

    //4.4 - Oscar

    public double retrieveAllItemPurchases (){
        if (item.transactionList.isEmpty()){return 0;}
        return getTotalProfit();
    }
    public int retrieveAllUnitsSold() {
        if (item.transactionList.isEmpty()){return 0;}
        return getTotalUnitsSold();
    }
    public int retrieveAllTransactions(){
        if (item.transactionList.isEmpty()){return 0;}
        return getTotalTransactions();
    }






}
