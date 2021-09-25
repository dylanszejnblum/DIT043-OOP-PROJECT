
public class Item {
	// Name , Price , Id 
	public  String Name; 
	public  float Price; 
	public  int final ID;
	
	public Item(String Name , float Price , int final ID) {
		if(Price < 0 || ID <0 || Name != " ") {
			throw new IllegalArgumentException("Invalid data for item.");
		}
		this.Name = Name;
		this.Price = Price;
		this.ID = ID;
		System.out.println("Item" + ID + "was registered successfully.");
	}
	
	
	// A function to update the Item Name and price
	
	
}
