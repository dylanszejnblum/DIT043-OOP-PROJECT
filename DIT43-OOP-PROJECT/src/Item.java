import java.util.ArrayList;

public class Item {
 
    public  String Name;
    public  double Price;
    public  int  ID;
    public ArrayList <Integer> grades = new ArrayList<Integer>();
    public ArrayList <String> writtenComments = new ArrayList<String>();


    public Item() {
        if(Price < 0 || ID <0 || Name != " ") {
            throw new IllegalArgumentException("Invalid data for item.");
        }
        /*
        this.Name = Name;
        this.Price = Price;
        this.ID = ID;

        System.out.println("Item" + ID + "was registered successfully.");

         */
        //ASK DYLAN ABOUT THE INPUT
        this.Name = UserInput.readString("Enter name: ");
        this.Price = UserInput.readDouble("Enter price: ");
        this.ID = UserInput.readInt("Enter ID: ");

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

    public void UpdateItem(int Price , String Name) {
        this.Price = Price;
        this.Name = Name;

    }
}

