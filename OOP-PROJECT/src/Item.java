
public class Item {
	// Name , Price , Id 
	public  String Name; 
	public  float Price; 
	public  int ID;
	
	public Item(String Name , float Price , int ID) {
		if(Price < 0 || ID <0) {
			throw new IllegalArgumentException("Price or id should be greater at least 1 ");
		}
		this.Name = Name;
		this.Price = Price;
		this.ID = ID;
	}
	
	
	// A function to update the Item Name and price
	
	
}
