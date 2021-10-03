import java.util.ArrayList;

public class Items {
	public static ArrayList<Item> ItemList =   new ArrayList<Item>();

	//SEARCH FOR AN ITEM BY USING THE ID
	public Item GetItemById(int ID) {
		for(Item item : ItemList) {
			if(item.GetId() == ID) {
				return item;
			}
		}
		return null;
	}
	//METHOD FOR BUYING AN ITEM
	float BuyItems(int ID , int ammount) {
		Item I = GetItemById(ID);
		float quantity = (float) ammount;
		if(ammount < 0) {
			throw new IllegalArgumentException("Invalid data for item.");

		}
		
		float Total = I.GetPrice() * quantity;
		
		if(ammount > 4) {
			Total = (float) (Total * 0.7);
		}
		
		return Total;
	}

	//CHANGE REMOVE ITEM METHOD
	ArrayList<Item> removeItem (int ID) {
		Item I = GetItemById(ID);
		for (int i = 0; i< ItemList.size(); i++) {
			
		}

	}
	
	String PrintSpecific(int ID) {
		Item I = GetItemById(ID);
		System.out.println(I.GetId() + ":" + I.GetName() + "  " + I.GetPrice() + "SEK.");
		return null;
	}
	//we cannot put prints on other classes that are not main so
	//this may need to be changed into a return statement using a toString()

	public String printAllItems(){
		String result = "";
		for (int i = 0; i < ItemList.size(); i++) {
			result += ItemList.GetID() + ": " + ItemList.GetName() + ". " + ItemList.GetPrice() + " SEK" + "\n";
		}
		return result;
	}

	public Items() {
		
	}
	
	

}
