package primitives;
import java.util.ArrayList;

public class Item {
    public String name;
    public double price;
    public String ID;
    public ArrayList <Integer> grades;
    public ArrayList <String> writtenComments;
    public ArrayList<Transaction> transactionList;
    public ArrayList<String> transactionStringArray;

    public ArrayList<Review> reviewList;
    public Item(String  ID,String name, double price) {
        this.name = name;
        this.price = price; // do we really need to truncate :)
        this.ID = ID;
        this.grades = new  ArrayList<Integer>();
        this.writtenComments =  new ArrayList<String>();

        this.reviewList = new ArrayList<Review>();
    }

    public String getId() {
        return this.ID;
    }

    public void setPrice (double newPrice) {this.price = newPrice; }
    public double getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String newName) {this.name = newName;}


    /*
    public boolean equals(Item anotherItem){
        if(anotherItem == this){
            return true;

        } else if(anotherItem == null){
            return false;

        } else if ( anotherItem instanceof Item ){
            return (this.getId() ==  anotherItem.getId());

        } else {
            return false;
        }
    }

     */
}
