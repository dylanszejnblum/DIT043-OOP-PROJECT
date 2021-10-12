import java.util.ArrayList;

public class Item {
 
    public  String Name;
    public  double Price;
    public  int  ID;
    public ArrayList <Integer> grades;
    public ArrayList <String> writtenComments;


    public Item() {
        if(Price < 0 || ID <0 || Name != " ") {
            throw new IllegalArgumentException("Invalid data for item.");
        }
        this.Price = UserInput.readDouble("Enter price: ");
        this.ID = UserInput.readInt("Enter ID: ");
        this.grades = new  ArrayList<Integer>();
        this.writtenComments =  new ArrayList<String>();

    }



    public int GetId() {
        return this.ID;
    }

    public double GetPrice() {
        return this.Price;
    }

    public String GetName() {
        return this.Name;
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
    public void UpdatePriceItem(int Price) {
        this.Price = Price;

    }

    public void UpdateNameItem(String Name) {
        this.Name = Name;
    }
}

