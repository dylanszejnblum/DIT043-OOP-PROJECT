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

    // A function to update the Item Name and price
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
    public String updatePriceItem(double newPrice) {
        if (price< 0){
            return "Invalid data for the item";
        }

        else {
            this.setPrice(newPrice);
            return  "Item "+ this.getId()+ " was updated successfully.";
        }

    }

    public String updateNameItem( String newName) {
        if (newName.isEmpty()) {
            return "Invalid data for the item.";
        }
        else {

            setName(newName);
            return  "Item "+ this.getId()+ " was updated successfully.";
        }




    }

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
}
