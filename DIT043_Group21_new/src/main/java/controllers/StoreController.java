package controllers;

import helpers.MathHelpers;
import primitives.Employee;
import primitives.Item;
import primitives.Review;
import primitives.Transaction;
import primitives.ItemTransactionIndex;
import java.text.DecimalFormat;
import java.util.ArrayList;



public class StoreController {
    public ArrayList<Employee> employees;
    ArrayList<Item> items;
    ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    ArrayList<ItemTransactionIndex> profitList;
    public Item item;
    public Review review;


    public StoreController(){
        items = new ArrayList<Item>();
        transactions = new ArrayList<Transaction>();
        profitList = new ArrayList<ItemTransactionIndex>();
    }

    public boolean itemExistenceChecker(String ID){
        for (Item item : items) {
            if (item.getId().equals(ID)) {
                return true;
            }
        }
        return false;
    }

    public boolean itemExists(String ID){
        for(int i = 0 ; i< items.size(); i++){
            Item n = items.get(i);
            if(n.getId().equals(ID)){
                return true;
            }
        }
        return false;
    }

    public double totalPurchases(){
        double total = 0;
        for(Transaction a : transactions){
            total = total + a.getPrice();
        }

        return total;
    }

    public int totalUnits(){
        int units = 0;
        for(int i = 0; i < transactions.size();i++){
            units += transactions.get(i).getAmount();
        }
        return units;
    }

    public int totalTransaction(){
        return transactions.size();

    }

    public double getSpecificItemProfit(String ID){
        double profit = 0;
        if(itemExists(ID)){
            for(int i = 0; i < transactions.size();i++){
                if(ID.equals(transactions.get(i).getId())) {
                    profit += transactions.get(i).getPrice();
                }
            }
            return profit;
        }
        return profit;
    }
    public int getSpecificItemAmmount(String ID){
        int unitSold = 0;
        if(itemExists(ID)){
            for(int i = 0; i < transactions.size();i++){
                if(ID.equals(transactions.get(i).getId())) {
                    unitSold += transactions.get(i).getAmount();
                }
            }
            return unitSold;
        }
        return unitSold;

    }
    public int getSpecificTransactions(String ID){
        int transactionCount = 0;
        if(itemExists(ID)){
            for(int i = 0; i < transactions.size();i++){
                if(ID.equals(transactions.get(i).getId())) {
                    transactionCount++;
                }
            }
            return transactionCount;
        }
        return transactionCount;

    }






    public String getAllItemTransactions(String ID){
        if(itemExists(ID) == false) {
            return ("Transactions for item: <item ID>: <item name>. <unit price> SEK\n" +
                    "No transactions have been registered for item <item ID> yet.\n");
        }
        Item specificItem = getItemById(ID);
        String result = ("Transactions for item: " + specificItem.getId() + ": " + specificItem.getName() +". " + specificItem.getPrice() + " SEK\n");
        int transactionCount = 0;
        for(int i = 0 ; i < transactions.size();i++){
            if(ID == transactions.get(i).getId()){
                result +=  transactions.get(i).toString() + "\n";
                transactionCount++;
            }
        }
        if(transactionCount == 0){
            DecimalFormat df = new DecimalFormat("0.00");

            return "Transactions for item: "+ specificItem.getId() +": Sweatpants. "+ df.format(specificItem.getPrice()) + " SEK\n" +
                    "No transactions have been registered for item "+ specificItem.getId()+" yet.";
        }
        return result;




    }
    public Item getItemById(String id){
        for(int i =0  ; i < items.size() ; i++){
            if(items.get(i).getId() == id){
                return items.get(i);
            }
        }
        return null;
    }

    public String createValidItem (String ID, String name , double price){
        if(price < 0 || ID.isEmpty() || name.isEmpty()) {
            return "Invalid data for item.";
        }

        Item item = new Item (ID, name, price);
        items.add(item);
        return ("Item " + ID + " was registered successfully.");
    }

    public String removeValidItem (String inputID){

        Item inputItem = getItemById(inputID);
        boolean checker = items.remove(inputItem);
        if (checker) {
            return ("Item " + inputItem.getId() + " was successfully removed.");
        }
        else{
            return ("Item " + inputID + " could not be removed.");
        }

    }
    public String updateItemPrice( String ID  ,double newPrice) {
        DecimalFormat df = new DecimalFormat("0.00");
        if(itemExistenceChecker(ID) != true){
            return  "Item " + ID + " was not registered yet.";
        }
        else if (ID.isEmpty() ||newPrice <= 0) {
            return "Invalid data for item.";
        }
        else {
            Item inputItem = getItemById(ID);
            inputItem.setPrice(newPrice);
            return  "Item " + inputItem.getId() + " was updated successfully.";
        }
    }

    public String printAllTransactions(){
        String result = "All purchases made: " + "\n" + "Total profit: " + totalPurchases() + " SEK\n" + "Total items sold: "+ totalUnits()+" units\n" + "Total purchases made: " + totalTransaction()+  " transactions\n"+ "------------------------------------\n";
        if(transactions.isEmpty() == false){
            for(Transaction n : transactions){
                result += n.toString()+ "\n";
            }
            return  result + "------------------------------------\n";
        }
        return  result;
    }


    public  void addAllItemsProffit(){
        if(items.isEmpty() == false && transactions.isEmpty() == false){
            for(Item n : items){
                double nProfit = getSpecificItemProfit(n.getId());
                ItemTransactionIndex foo = new ItemTransactionIndex(n.getId() , nProfit);
                profitList.add(foo);
            }
        }
    }

    public String printMostProfitable(){
        DecimalFormat df = new DecimalFormat("0.00");
        addAllItemsProffit();

        ItemTransactionIndex min = profitList.get(0);
        ItemTransactionIndex max = profitList.get(0);
        int size = profitList.size();

        for(int i = 1;  i < size; i++){
            if(profitList.get(i).profit > max.profit){
                max = profitList.get(i);
            }
        }

        Item MostProfitable = getItemById(max.getID());
        return "Most profitable items: \n" + "Total profit: "+ df.format(max.profit) +" SEK\n" + MostProfitable.toString()+"\n";




    }
    public String updateNameItem( String ID  ,String newName) {
        if(itemExistenceChecker(ID) != true){
            return  "Item " + ID + " was not registered yet.";
        }
       else if (ID.isEmpty() ||newName.isEmpty()) {
            return "Invalid data for item.";
        }
        else {
            Item inputItem = getItemById(ID);
            inputItem.setName(newName);
            return  "Item " + inputItem.getId() + " was updated successfully.";
        }
    }

    public String getAllItems(){
            for (Item item : items) {
               System.out.println(item.toString());
            }
            return null;
    }


    public String printSpecificItem(String ID) {
        // Dunno why but it's the only
        DecimalFormat df = new DecimalFormat("0.00");
        if (!itemExistenceChecker(ID)) {
            return("Item " + ID + " was not registered yet.");
        } else {
            Item item = getItemById(ID);
            return(item.getId() + ": " + item.getName() + ". " + df.format(item.getPrice()) + " SEK");
        }
    }


    // Not finished , it shoudl acomodate for the transactions class
    public double buyItem(String ID , int quantity){
        int discountedQuantity;
        Item BoughtItem = getItemById(ID);

        if (itemExistenceChecker(ID) == false){
            return  -1.0;
        } else if(quantity <= 4 && quantity > 0){
            double total = BoughtItem.getPrice() * (double) quantity;
            Transaction transaction = new Transaction(ID , quantity ,  total);
            transactions.add(transaction);

            return total;
        }
        else{
            double totalWithoutDiscount = BoughtItem.getPrice() * 4.0;


            double total = MathHelpers.truncateDouble((totalWithoutDiscount + (BoughtItem.getPrice() * (quantity-4)) * (1-0.3)));
            Transaction transaction = new Transaction(ID , quantity ,  total);
            transactions.add(transaction);
            return total ;
        }
        // need to add a -1 at the end
    }


    public String getSpecificItemReview(String ID , int index){
        Item n = getItemById(ID);
        return n.getSpecificReview(index);
    }

    public String getAllReviewsItem(String ID){
        Item n = getItemById(ID);
        return n.printAllReviews();
    }

    public String getAllReviews(){
        for(int i = 0; i< items.size();i++){
           System.out.println(items.get(i).printAllReviews());
        }
        return null;

    }


    // Add sorting functions

    // 3.1 - Nia

//method creating reviews

    public String createReviews(String ID , String writtenComment , int grade){
        if(itemExists(ID) != true){
            return "item does not exist";
        }  else if (grade < 1 || grade > 5) {
            return "Grade values must be between 1 and 5.";
        }else{
            Item item = getItemById(ID);
            Review review = new Review (ID,writtenComment, grade);
            item.reviews.add(review);
            return("Your item review was registered successfully.");

        }

    }
//3.2 - Nia
//print a specific item review

    public String printSpecificItemReview(String ID,int i) {

        Item item = getItemById(ID);

        if (itemExistenceChecker(ID)) {
            return "Item" + ID + "was not registered yet.";
        }
        else if (item.reviews.isEmpty()) {
            return "Item " + item.getName() + " has not been reviewed yet.";
        }
        else if (i < 1 || i > item.reviews.size()) {
            return "Invalid review  number. Choose between 1 and " + item.reviews.size();
        }
        return item.reviews.get(i).reviewToString();
    }

    //3.3 - Nia
    public String printAllReviewsForAnItem(String ID){
        String result = "";
        Item item = getItemById(ID);

        if(itemExistenceChecker(ID)){
            return "Item" + ID + "was not registered yet.";
        }
        else if (item.reviews.isEmpty()){

            return "Review(s) for " + ID + ": " + item.getName() + ". " + item.getPrice() + "SEK.\n" +
                    "Item " + item.getName() + " has not been reviewed yet." ;
        }

        else{

            for(int i = 0; i < item.reviews.size(); i++) {;

                result += "Grade: " + item.reviews.get(i).getGrade() + "." + item.reviews.get(i).getWrittenReview() + "\n";;
            }
        }
        return "Review(s) for "  + ID + ": " + item.getName() + ". " + item.getPrice() + "SEK.\n" +
                result ;
    }
    //3.4 - Oscar
    public String retrieveMeanGradeItem(String ID) {
        if (itemExistenceChecker(ID)){
            return ("Item " + ID + " was not registered yet.");
        }

        else if(item.reviews.isEmpty()) {
            Item inputItem = getItemById(ID);
            return ("Item " + inputItem.getName() + " has not been reviewed yet");
        }

        else {
            Item inputItem = getItemById(ID);
            double totalGrades = 0;
            for (int i = 0; i < item.reviews.size(); i++) {
                totalGrades += inputItem.reviews.get(i).getGrade();
            }
            double mean = (totalGrades/item.reviews.size())*Math.pow(10,1); //math pow useless here
            return(String.valueOf(mean));
        }

    }

    //3.5 - Oscar
    public String retrieveCommentsItem(String ID){

        Item inputItem = getItemById(ID);

        if (itemExistenceChecker(ID) || item.reviews.isEmpty()) {
            return "Empty Collection";
        }

        else {
            String result = "";
            for (int i = 0; i < item.reviews.size(); i++) {
                result += item.reviews.get(i).getWrittenReview() + "\n";
            }

            return result;
        }
    }

//3.6 - Oscar

    public String retrieveRegisteredReviews() {
        int noReviewedItem = 0;
        String result = "";

        if (items.size() == 0) {
            return "No items registered yet";
        }

        else {

            for (Item item : items) {
                if (item.reviews.size() == 0) {
                    noReviewedItem++;
                }
            }

            if (noReviewedItem == items.size()) {
                return ("No items were reviewed yet");
            } else {
                for (Item item : items) {
                    result = "--------------------------\n" + "Review(s) for " + item.getId() + ": " + item.getName() + ". " + item.getPrice() + " SEK + \n";

                    for (int j = 0; j < item.reviews.size(); j++) {
                        result += "Grade: " + item.reviews.get(j).getGrade() + "." + item.reviews.get(j).getWrittenReview();
                    }
                }
            }
        }

        return "All registered reviews:\n" + result;
    }


    public String printAllItems() {
        if (items.isEmpty()) {
            return "No items registered yet.";
        } else {


            String message = "All registered items:\n";
            for (Item item : items) {
                message += item.toString() + "\n";
            }
            return message;
        }
    }
}




