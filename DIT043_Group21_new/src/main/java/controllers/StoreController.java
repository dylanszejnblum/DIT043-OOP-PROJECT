package controllers;

import primitives.Employee;
import primitives.Item;
import primitives.Review;
import primitives.Transaction;

import java.util.ArrayList;


// I should have added a get by id , i'm not thingking logically
public class StoreController {
    public ArrayList<Employee> employees;
    ArrayList<Item> items;
    ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    public Item item;
    public Review review;


    public StoreController(){
        items = new ArrayList<Item>();
        transactions = new ArrayList<Transaction>();
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
        double totalProfit = 0;
        for(int i = 0; i < transactions.size();i++){
            totalProfit += transactions.get(i).getPrice();
        }
        return totalProfit;
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


    // If it is a print i think void could also work
    // By tommorrow the best thing to do it would be to decouple this functions from transactions into two diffrernt ones
    public String getAllItemTransactions(String ID){
        if(itemExists(ID)){
            System.out.println("Transactions for item: <item ID>: <item name>. <unit price> SEK");

            for(int i = 0 ; i < transactions.size();i++){
                if(ID == transactions.get(i).getId()){
                   System.out.println(transactions.get(i).toString());
                }
            }
        }else{
            System.out.println("Transactions for item: <item ID>: <item name>. <unit price> SEK\n" +
                    "No transactions have been registered for item <item ID> yet.\n");
        }

        return null;

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
        //double newPrice = MathHelpers.truncateDouble(price);
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
            return ("Item" + inputID + "could not be removed.");
        }

    }
    public String updatePriceItem(double newPrice) {
        if (item.getPrice()< 0){
            return "Invalid data for the item";
        }
        else {
            this.item.setPrice(newPrice);
            return  "Item "+ this.item.getId()+ " was updated successfully.";
        }
    }

    public String updateNameItem( String newName, String ID) {
        if (ID.isEmpty() ||newName.isEmpty()|| !itemExistenceChecker(ID)) {
            return "Invalid data for the item.";
        }
        else {
            Item inputItem = getItemById(ID);
            inputItem.setName(newName);
            return  "Item " + ID + " was updated successfully.";
        }
    }

    public String getAllItems(){
            for (Item item : items) {
               System.out.println(item.toString());
            }
            return null;
    }


    public String printSpecificItem(String ID) {
        if (!itemExistenceChecker(ID)) {
            return("Item " + ID + " was not registered yet.");
        } else {
            Item item = getItemById(ID);
            return(item.getId() + ": " + item.getName() + ". " + item.getPrice() + " SEK");
        }
    }


    // Not finished , it shoudl acomodate for the transactions class
    public double buyItem(int quantity , String ID){

        Item BoughtItem = getItemById(ID);
        double total = BoughtItem.getPrice() * quantity;

        Transaction transaction = new Transaction(ID , quantity ,  BoughtItem.getPrice());
        transactions.add(transaction);

        if(quantity >4){
            total = total * 0.7;
            return total;
        }
        return total;
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

    public String createReviews(String ID, int grade, String writtenComment){

        if (!itemExistenceChecker(ID)) {
            return("Item " + ID + " was not registered yet.");
        }
        else if (grade < 1 || grade > 5) {
            return("Grade values must be between 1 and 5.");
        }
        else {
            Item item = getItemById(ID);
            Review review = new Review (ID,grade, writtenComment);
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


}




