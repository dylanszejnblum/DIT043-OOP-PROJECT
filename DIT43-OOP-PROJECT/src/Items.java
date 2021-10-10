import java.util.ArrayList;

public class Items {
    public ArrayList<Item> ItemList =   new ArrayList<Item>();

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
    public float BuyItems(int ID , int ammount) {
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

    // Simple add item method
    public void addItem(Item newItem) {
        ItemList.add(newItem);
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
                System.out.println(item.GetId() + ":" + item.GetName() + ". " + item.GetPrice() + "SEK.");
            }

        }
    }//method transaction menu
    public void totalProfitFromAllItemsPurchased() {
        double totalProfit = 0;
        for (int i = 0; i < ItemList.size(); i++) {
            Item item = ItemList.get(i);
            double specificPrice = item.GetPrice();
            totalProfit += specificPrice;
        }
        System.out.println(totalProfit);

    }


    //3.1 - Nia

    //method creating reviews
    //the need of a scanner?
    public void createReviews() {

        int ID = readInt("Please, specify the ID of the item being reviewed:");

        int grade = readInt("You can choose a grade for your review between 1 to 5. Please, type your grade here:");

        String writtenComment = readString("Optionally, you can add a written comment if you'd like:");

        Item item = GetItemById(ID);
        if (item == null ) {
            System.out.println("Item" + ID + "was not registered yet.");

        } else {
            System.out.println("Your review was registered succesfully.");

            int i = grades.size();
            item.grades.add(i, grade);
            item.writtenComments.add(i, writtenComment);

            System.out.println("Your review was registered succesfully.");
        }

    }
    //3.2 - Nia
    //print a specific item review

    public void printSpecificItemReview(){
        //specifying the item ID
        //index of the desired review - from 1(first item's review)


        int ID = readInt("Please, specify the item's ID:");
        int i = readInt("Type the index of the desired review: \n" +"" +
                "*This means if you want to get an item's first review, you should type 1*");

        Item item = GetItemById(ID);

        if (item == null){
            System.out.println("Item" + ID + "was not registered yet");
        }
        if(item.grades.size() == 0 && item.writtenComments.size() == 0){
            System.out.println("Item" + item.GetName() + "has not been reviewed yet.");
        }

        else if(i < 1) {
            System.out.println("Invalid review number. Choose between 1 and" + " " + item.grades.size());

        }else{
            System.out.println("Grade:" + " " + item.grades.get(i) + "." + item.writtenComments.get(i));

        }

    }

    //3.3 - Nia
    public void printAllReviewsForAnItem(){

        int ID = readInt("Please, specify the item's ID:");
        Item item = GetItemById(ID);

        if(item == null){
            System.out.println("Item" + ID + "was not registered yet.");
        }
        else if (item.grades.size() == 0 && item.writtenComments.size() == 0){
            System.out.println("Review(s) for " + ID + ": " + item.GetName() + ". " + item.GetPrice() + "SEK.\n" +
                    "Item " + item.GetName() + " has not been reviewed yet." );
        }

        else{
            System.out.println("Review(s) for "  + ID + ": " + item.GetName() + ". " + item.GetPrice() + "SEK.");

            for(int i = 0; i < item.grades.size(); i++) {
                System.out.println("Grade: " + item.grades.get(i) + "." + item.writtenComments.get(i));
            }

        }
    }

    public void retrieveMeanGradeItem() {
    //How can I call the grades arrayList from the other class, maybe by composition??
    int inputID = UserInput.readInt("Introduce the desired ID: ");
        Item inputItem = GetItemById(inputID);

        double totalGrades = 0;
        for (int i = 0; i < grades.size(); i++) {
            totalGrades += inputItem.grades.get(i);
        }

        double mean = totalGrades/grades.size();

    }
}




