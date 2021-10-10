import java.util.ArrayList;

public class Item {
 
    public  String Name;
    public  float Price;
    public  int  ID;
    public ArrayList <Integer> grades = new ArrayList<Integer>();
    public ArrayList <String> writtenComments = new ArrayList<String>();


    public Item(String Name , float Price , int  ID ) {
        if(Price < 0 || ID <0 || Name != " ") {
            throw new IllegalArgumentException("Invalid data for item.");
        }
        this.Name = Name;
        this.Price = Price;
        this.ID = ID;

        System.out.println("Item" + ID + "was registered successfully.");
    }



    public int GetId() {
        return this.ID;
    }

    public float GetPrice() {
        return this.Price;
    }

    public String GetName() {
        return this.Name;
    }
    // A function to update the Item Name and price

    public void UpdateItem(int Price , String Name) {
        this.Price = Price;
        this.Name = Name;

    }
}
