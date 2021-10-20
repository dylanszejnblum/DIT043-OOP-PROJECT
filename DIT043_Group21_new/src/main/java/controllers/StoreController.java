package controllers;

import primitives.Item;
import primitives.Review;
import primitives.Transaction;

import java.util.ArrayList;


// I should have added a get by id , i'm not thingking logically
public class StoreController {
    public ArrayList<Item> items;
    public ArrayList<Transaction> transactions;
    public StoreController(){
         ArrayList<Item> items = new ArrayList<Item>();
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    }


    public boolean ItemExists(String ID){
        for(int i = 0 ; i< items.size(); i++){
            Item n = items.get(i);
            if(n.getId().equals(ID)){
                return true;
            }
        }
        return false;
    }


    public Item GetItemById(String id){
        for(int i =0  ; i < items.size() ; i++){
            if(items.get(i).getId() == id){
                return items.get(i);
            }
        }
        return null;
    }

    public void CreateItem(String  ID,String name, double price){
        if(ItemExists(ID) == false) {
            Item newItem = new Item(ID, name, price);
        }
    }

    public void RemoveItem(String ID){
        for(int i = 0; i< items.size(); i++){
            Item n = items.get(i);
            if(n.getId().equals(ID)){
                items.remove(i);
                System.out.println("Item" + ID +"was successfully removed");
            }
        }
        if(ItemExists(ID) == false){
            System.out.println("Item" + ID +" could not be removed"); // This is 3 am coding voiding any logic

        }
    }
    public void UpdatePrice(String ID , Double NewPrice){
         for(int i = 0; i< items.size(); i++){
             Item n = items.get(i);
             if(n.getId().equals(ID)){
                 items.get(i).UpdatePrice(NewPrice);
             }
        }
    }
    public void UpdateName(String ID , String NewName){
        for(int i = 0; i< items.size(); i++){
            Item n = items.get(i);
            if(n.getId().equals(ID)){
                items.get(i).UpdateName(NewName);
            }
        }
    }

    public String GetAllItems(){
            for (Item item : items) {
               System.out.println(item.toString());
            }
            return null;
    }

    // Not finished , it shoudl acomodate for the transactions class
    public Double BuyItem(int quantity , String ID){
        Item BoughtItem = GetItemById(ID);
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
    }




