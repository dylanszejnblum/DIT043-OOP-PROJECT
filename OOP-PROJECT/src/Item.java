
public class Item {
	// Name , Price , Id 
	public  String Name; 
	public  float Price; 
	public  int  ID;
	
	public Item(String Name , float Price , int  ID) {
		if(Price < 0 || ID <0 || Name != " ") {
			throw new IllegalArgumentException("Invalid data for item.");
		}
		this.Name = Name;
		this.Price = Price;
		this.ID = ID;
		System.out.println("Item" + ID + "was registered successfully.");
	}
	
	
	// A function to update the Item Name and price
	
	public void UpdateItem(int Price , String Name) {
		this.Price = Price;
		this.Name = Name;
		
	}
}
