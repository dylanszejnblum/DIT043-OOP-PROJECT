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

// I did changes to 2.5; 2.6; 2.7 
	//remove items - 2.5

	public String removeItem (int ID){

		for(Item item : ItemList) {
			if(item.GetId() == ID){

				ItemList.remove(item);
				//do we have like a null element on that position after removing?
			}
				return "Item" + ID + "was successfully removed.";
			}
			  else { return "Item" + ID + "could not be removed.";}
		}

	}

//print specific item? - 2.6


public void PrintSpecificItem(int ID) {
	Item I = GetItemById(ID);

	if (I == null) {
		System.out.println("Item" + ID + "was not registered yet.");
	} else {
		//rounding steps, to 2nd decimal; ASK DYLAN!!!!!
		double priceOfItem = I.GetPrice();
		double scale = Math.pow(10, 2);
		double roundingThePrice = Math.round(priceOfItem * scale) / scale;
		roundingThePrice = priceOfItem;

		System.out.println(I.GetId() + ":" + I.GetName() + "  " + priceOfItem + "SEK.");

	}

}
	//print all registered items - 2.7
	//we cannot put prints on other classes that are not main so
	//this may need to be changed into a return statement using a toString()

	public void printAllItems() {
		System.out.println("All registered items:");

		boolean empty = ItemList.isEmpty();

		if (empty = true) {
			System.out.println("No items registered yet.");

		} else {

			for (Item item : ItemList) {
				System.out.println(item.GetId() + ":" + item.GetName + ". " + item.GetPrice + "SEK.");
			}

		}
	}
	public Items() {
		
	}
	
	

}
