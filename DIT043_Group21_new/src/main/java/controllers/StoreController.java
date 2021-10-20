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
    public Employee employee;
    public MathHelpers mathHelper;

    public StoreController(){
        ArrayList<Employee> employees = new ArrayList<Employee>();
        ArrayList<Item> items = new ArrayList<Item>();
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
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


    public Item getItemById(String id){
        for(int i =0  ; i < items.size() ; i++){
            if(items.get(i).getId() == id){
                return items.get(i);
            }
        }
        return null;
    }

    public void createItem(String  ID,String name, double price){
        if(itemExists(ID) == false) {
            Item newItem = new Item(ID, name, price);
        }
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


//---------------------------------------EPIC FEATURE 5-------------------------------------------------

    public boolean equals(Employee anotherEmployee){
    if(anotherEmployee == this.employee){
        return true;

    } else if(anotherEmployee == null){
        return false;

    } else if ( anotherEmployee instanceof Employee ){
        return (this.employee.getID().equals(anotherEmployee.getID()));

    } else {
        return false;
    }
}

    public String toString() {
        return this.employee.getName() + "'s gross salary is " + this.employee.getInitialGrossSalary() + " SEK per month";
    }

    public String createEmployee (String ID, String name, double grossSalary) {
        Employee employee = new Employee(ID, name, grossSalary);
        return "Employee " + this.employee.getID() + " registered successfully.";

    }

    public double calculateNetSalary() {
         double finalNetSalary = 0.0;
         finalNetSalary= employee.getNetSalary() - (this.employee.getInitialGrossSalary() * employee.getTAX_PERCENTAGE());
         return MathHelpers.truncateDouble(finalNetSalary);
        // Add the truncate function into the helpers
    }


}




