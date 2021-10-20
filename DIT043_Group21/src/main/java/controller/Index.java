package controller;

import helpers.UserInput;
import primitives.*;

public class Index  {

    public Items items;
    public Item item;
    public Transaction transaction;

//----------------------------EPIC FEATURE 2 --------------------------------------------------------------------
    //We need a method for checking if an item exists
    public boolean itemExistenceChecker(String ID){
        for (Item item : items.itemList) {
            if (item.getId().equals(ID)) {
                return true;
            }
        }
        return false;
    }


    //SEARCH FOR AN ITEM BY USING THE ID
    public Item getItemByID(String ID) {
        for(Item item : items.itemList) {
            if(item.getId().equals(ID)){
                return item;
            }
            //what about if it does not find it, return null? we need an alternative
        }
        return null;
    }

    //METHOD FOR BUYING AN ITEM
    public String updatePriceItem(double newPrice) {
        if (item.getPrice()< 0){
            return "Invalid data for the item";
        }
        else {
            this.item.setPrice(newPrice);
            return  "Item "+ this.item.getId()+ " was updated successfully.";
        }
    }

    public String updateNameItem( String newName) {
        if (newName.isEmpty()) {
            return "Invalid data for the item.";
        }
        else {

            item.setName(newName);
            return  "Item "+ this.item.getId()+ " was updated successfully.";
        }
    }


    public double buyItems(String ID , int amount) {
        double total = 0.0;
        if (!itemExistenceChecker(ID)) {
            return -1;
        }

        else {
            Item item = getItemByID(ID);

            if ((double) amount < 0) {
                return -1;
            }

            if ( amount > 4) {
                total =  (4 * item.getPrice() + (amount-4)* (item.getPrice()*0.7));
                return total;
            }

            else{
                total =  (item.getPrice()*(double)amount);
                return total;
            }

            /*
            Transaction transaction = new Transaction(ID, total, amount);
            item.transactionList.add(transaction);
            final String transactionString = transaction.getID() + ": " + transaction.getUnitsSold() + " item(s). " + item.getPrice() + " SEK";
            item.transactionStringArray.add(transactionString);
             */
        }
    }

    public String createItem (String name, double price , String ID){
        String result = "";
        Item item = new Item (ID, name, price);
        if(price < 0 || ID.isEmpty() || name == "") {
            return "Invalid data for item.";
        }
        items.itemList.add(item);
        return ("Item " + item.getId() + " was registered successfully.");
    }

    // Simple add item method
    public void addItem(Item newItem) {

        //Item item = new Item(String Name, double Price, int ID);
        items.itemList.add(newItem);
    }

    //remove items - 2.5
    public String removeItem (String inputID){

        Item inputItem = getItemByID(inputID);

        boolean checker = items.itemList.remove(inputItem);

        if (checker) {
            return ("Item " + inputItem.getId() + " was successfully removed.");
        }
        else{
            return ("Item" + inputID + "could not be removed.");
        }

    }


    //print specific item? - 2.6
    public String printSpecificItem(String ID) {

        if (!itemExistenceChecker(ID)) {
            return("Item " + ID + " was not registered yet.");

        } else {
            Item item = getItemByID(ID);
            double priceOfItem = item.getPrice();
            priceOfItem = priceOfItem;

            return(item.getId() + ": " + item.getName() + ". " + priceOfItem + " SEK");
        }
    }
    //print all registered items - 2.7
    //we cannot put prints on other classes that are not main so
    //this may need to be changed into a return statement using a toString()

    public String printAllItems() {
        String result  = ("All registered items: \n");
        if (items.itemList.isEmpty()) {
            return("No items registered yet.");
        }
        else {
            for (Item item : items.itemList) {
                result += (item.getId() + ": " + item.getName() + ". " + item.getPrice() + " SEK \n");
            }
            return result;

        }
    }
//---------------------------------------EPIC FEATURE 3-------------------------------------------------

    public int getReviewLength(){
        return this.writtenComments.size();
    }

    public int getMeanGrade(){
        int total = 0;
        int average = 0;
        for(int i = 0 ; i < grades.size(); i++){
            total += grades.get(i);
            average = total / grades.size();
            return average;
        }
        return average;
    }

    //method transaction menu
    public void totalProfitFromAllItemsPurchased() {
        double totalProfit = 0;
        for (int i = 0; i < items.itemList.size(); i++) {
            Item item = items.itemList.get(i);
            double specificPrice = item.getPrice();
            totalProfit += specificPrice;
        }
        System.out.println(totalProfit);

    }


    //3.1 - Nia

    //method creating reviews
    //the need of a scanner?
    public String createReviews(String ID, int grade, String writtenComment) {

        //Pass these inputs to the menu class

        if (!itemExistenceChecker(ID) ) {
            return("Item" + ID + "was not registered yet.");

        }
        else if (grade < 1 || grade > 5) {
            return("Grade values must be between 1 and 5.");
        }
        else {
            Item item = getItemByID(ID);
            item.grades.add(grade);
            item.writtenComments.add(writtenComment);
            return("Your review was registered successfully.");
        }

    }
    //3.2 - Nia
    //print a specific item review

    public void printSpecificItemReview(String ID){
        //specifying the item ID
        //index of the desired review - from 1(first item's review)

        int i = UserInput.readInt("Type the index of the desired review: \n" +"" +
                "*This means if you want to get an item's first review, you should type 1*");

        Item item = getItemByID(ID);

        if (item == null){
            System.out.println("Item" + ID + "was not registered yet");
        }
        if(item.grades.size() == 0 && item.writtenComments.size() == 0){
            System.out.println("Item" + item.getName() + "has not been reviewed yet.");
        }

        else if(i < 1) {
            System.out.println("Invalid review number. Choose between 1 and" + " " + item.grades.size());

        }else{
            System.out.println("Grade:" + " " + item.grades.get(i) + "." + item.writtenComments.get(i));

        }

    }

    //3.3 - Nia
    public void printAllReviewsForAnItem(String ID){

        Item item = getItemByID(ID);

        if(item == null){
            System.out.println("Item" + ID + "was not registered yet.");
        }
        else if (item.grades.size() == 0 && item.writtenComments.size() == 0){
            System.out.println("Review(s) for " + ID + ": " + item.getName() + ". " + item.getPrice() + "SEK.\n" +
                    "Item " + item.getName() + " has not been reviewed yet." );
        }

        else{
            System.out.println("Review(s) for "  + ID + ": " + item.getName() + ". " + item.getPrice() + "SEK.");

            for(int i = 0; i < item.grades.size(); i++) {
                System.out.println("Grade: " + item.grades.get(i) + "." + item.writtenComments.get(i));
            }

        }
    }


    //3.4 - Oscar
    public String retrieveMeanGradeItem(String inputID) {

        Item inputItem = getItemByID(inputID);
        if (inputItem == null){
            return ("Item " + inputID + " was not registered yet.");
        }

        else if(inputItem.grades.size() == 0) {
            return ("Item " + inputItem.name + " has not been reviewed yet");
        }

        else {
            double totalGrades = 0;
            for (int i = 0; i < inputItem.grades.size(); i++) {
                totalGrades += inputItem.grades.get(i);
            }
            double mean = (totalGrades/inputItem.grades.size())*Math.pow(10,1);
            return(String.valueOf(mean));
        }

    }

    //3.5 - Oscar
    public String retrieveCommentsItem(String inputID){

        Item inputItem = getItemByID(inputID);

        if (inputItem == null || inputItem.writtenComments.size() == 0){
            return "Empty Collection";
        }

        else {
            String result = "";
            for (int i = 0; i < inputItem.writtenComments.size(); i++) {
                result += inputItem.writtenComments.get(i) + "\n";
            }

            return result;
        }
    }

    //3.6 - Oscar

    public String retrieveRegisteredReviews() {
        int noReviewedItem = 0;
        String result = "All registered reviews: \n"
                + "- \n";

        if (items.itemList.size() == 0) {
            return "No items registered yet";
        }

        else {
            for (Item item : items.itemList) {
                if ((item.writtenComments.size()==0 || item.writtenComments.isEmpty()) && item.grades.size() == 0) {
                    noReviewedItem ++;
                    //checking if all items have not been reviewed, if this variable
                    //equals the size of the ItemList means that no Items were reviewed
                }

                else {
                    result += "Review(s) for " + item.ID + ": " + item.name + ". " + item.price + " SEK + \n";
                    for (int j= 0; j < item.grades.size(); j ++) {
                        result += "Grade: " + item.grades.get(j) + "."+ item.writtenComments.get(j);
                    }

                }
                result += '-';
            }

            if (noReviewedItem == items.itemList.size()){
                return ("No items were reviewed yet");
            }
            else{
                return result;
            }
        }
    }



    public Item GetMostAndLeastReviewedItems(){
        Item min = items.itemList.get(0);
        Item max = items.itemList.get(0);

        int minIndex = 0;
        int maxIndex = 0;

        for(int i = 1; i < items.itemList.size(); i++){
            if(items.itemList.get(i).getReviewLength() < min.getReviewLength()){
                min = items.itemList.get(i);
                minIndex = i;
            }
            if(items.itemList.get(i).getReviewLength() > max.getReviewLength()){
                max = items.itemList.get(i);
                maxIndex = i;
            }
        }

        System.out.println("Most reviews: <num reviews> review(s) each.\n" +
                max.getId() +": " + max.getName()+ " " + max.getPrice() +" SEK\n" );

        System.out.println("Most reviews: <num reviews> review(s) each.\n" +
                min.getId() +": " + min.getName()+ " " + min.getPrice() +" SEK\n" );

        return max;


    }

    // 3.8 Print items with highest / lowest grades ~ Dylan
    public Item GetHighestGrade(){
        Item min = items.itemList.get(0);
        Item max = items.itemList.get(0);

        int minIndex = 0;
        int maxIndex = 0;

        for(int i = 1; i < items.itemList.size(); i++){
            if(items.itemList.get(i).getMeanGrade() < min.getMeanGrade()){
                min = items.itemList.get(i);
                minIndex = i;
            }
            if(items.itemList.get(i).getMeanGrade() > max.getMeanGrade()){
                max = items.itemList.get(i);
                maxIndex = i;
            }
        }

        return max;
    }

    public Item GetLowestGrade(){
        Item min = items.itemList.get(0);
        Item max = items.itemList.get(0);

        int minIndex = 0;
        int maxIndex = 0;

        for(int i = 1; i < items.itemList.size(); i++){
            if(items.itemList.get(i).getMeanGrade() < min.getMeanGrade()){
                min = items.itemList.get(i);
                minIndex = i;
            }
            if(items.itemList.get(i).getMeanGrade() > max.getMeanGrade()){
                max = items.itemList.get(i);
                maxIndex = i;
            }
        }
        return min;

    }
//----------------------EPIC FEATURE 4-----------------------------------------------------------

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
        double totalProfit = 0.0;
        for (Transaction transaction : item.transactionList) {
            totalProfit += transaction.getProfit();
        }
        return totalProfit;
    }

    public int getTotalUnitsSoldItem(Item item) {
        int totalUnitsSold = 0;
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
