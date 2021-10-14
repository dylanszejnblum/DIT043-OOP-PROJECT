package clothingstore;

import java.util.ArrayList;

public class Item {
 
    public  String name;
    public  double price;
    public  String  ID;
    public ArrayList <Integer> grades;
    public ArrayList <String> writtenComments;
    public ArrayList<Transaction> transactionList;
    public ArrayList<String> transactionStringArray;


    public Item(String  ID,String Name, double Price) {
        if(Price < 0 || ID.isEmpty() || Name != "") {
            throw new IllegalArgumentException("Invalid data for item.");
        }
        this.name = Name;
        this.price = Price;
        this.ID = ID;

        this.grades = new  ArrayList<Integer>();
        this.writtenComments =  new ArrayList<String>();

    }

    public String GetId() {
        return this.ID;
    }

    public double GetPrice() {
        return this.price;
    }

    public String GetName() {
        return this.name;
    }
    // A function to update the Item Name and price
    public int GetReviewLength(){
        return this.writtenComments.size();
    }

    public int GetMeanGrade(){
        int total = 0;
        int average = 0;
        for(int i = 0 ; i < grades.size(); i++){
            total += grades.get(i);
            average = total / grades.size();
            return average;

        }
        return average;

    }
    public void UpdatePriceItem(double Price) {
        this.price = Price;

    }

    public void UpdateNameItem(String Name) {
        this.name = Name;
    }

    public boolean equals(Item anotherItem){
        if(anotherItem == this){
            return true;

        } else if(anotherItem == null){
            return false;

        } else if ( anotherItem instanceof Item ){
            boolean isEqualItem = (this.GetId() ==  anotherItem.GetId()) ;
            return isEqualItem;

        } else {
            return false;
        }
    }


}

//1- Check equality of ID, create a method for that --> done.
//2- Truncation
//3- do while loops for menu
//4- Review class
//5- FACADE
//6- Create a method for checking if the ID exists or not. --> done.
//7- Encapsulation, we currently have no encapsulation --> done.
//8- Create toString methods in order to print, currently we have none
//9- Naming conventions according to Java