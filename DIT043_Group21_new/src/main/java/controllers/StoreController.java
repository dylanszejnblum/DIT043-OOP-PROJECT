package controllers;

import helpers.MathHelpers;
import primitives.Employee;
import primitives.Item;
import primitives.Review;
import primitives.Transaction;

import java.util.ArrayList;


// I should have added a get by id , i'm not thingking logically
public class StoreController {
    public ArrayList<Employee> employees;
    public ArrayList<Item> items;
    public ArrayList<Transaction> transactions;
    public Item item;


    public StoreController(){
        ArrayList<Item> items = new ArrayList<Item>();
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
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
        double totalProffit = 0;
        for(int i = 0; i < transactions.size();i++){
            totalProffit += transactions.get(i).getPrice();
        }
        return totalProffit;
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
        if(itemExists(ID) == true){
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
        Item item = new Item (ID, name, MathHelpers.truncateDouble(price));
        if(price < 0 || ID.isEmpty() || name.isEmpty()) {
            return "Invalid data for item.";
        }
        items.add(item);
        return ("Item " + ID + " was registered successfully.");
    }

    public void removeItem(String ID){
        for(int i = 0; i< items.size(); i++){
            Item n = items.get(i);
            if(n.getId().equals(ID)){
                items.remove(i);
                System.out.println("Item" + ID +"was successfully removed");
            }
        }
        if(itemExists(ID) == false){
            System.out.println("Item" + ID +" could not be removed"); // This is 3 am coding voiding any logic

        }
    }
    public void updatePrice(String ID , double newPrice){
         for(int i = 0; i< items.size(); i++){
             Item n = items.get(i);
             if(n.getId().equals(ID)){
                 items.get(i).setPrice(newPrice);
             }
        }
    }
    public void updateName(String ID , String newName){
        for(int i = 0; i< items.size(); i++){
            Item n = items.get(i);
            if(n.getId().equals(ID)){
                items.get(i).setName(newName);
            }
        }
    }


    public String getAllItems(){
            for (Item item : items) {
               System.out.println(item.toString());
            }
            return null;
    }


    public String printItem(String ID){
        return getItemById(ID).toString();
    }


    // Not finished , it shoudl acomodate for the transactions class
    public double buyItem(int quantity , String ID){
        Item BoughtItem = getItemById(ID);
        double total = BoughtItem.price * quantity;
        Transaction transaction = new Transaction(ID , quantity ,  BoughtItem.price);
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



}




