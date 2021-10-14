package clothingstore;

import java.util.ArrayList;

public class Items {

    public Item item;

    public ArrayList<Item> itemList;
    public Items(){
        itemList  =  new ArrayList<Item>();
    }

    //CHECK IF AN ITEM EXISTS
    //We need a method for checking if an item exists

    


    //SEARCH FOR AN ITEM BY USING THE ID
    public Item getItemByID(String ID) {
        for(Item item : itemList) {
            if(item.equals(ID)){
                return item;
            }
        }
        return null;
    }
    //METHOD FOR BUYING AN ITEM
    public double BuyItems(String ID , int amount) {
        Item I = getItemByID(ID);
        double quantity = (double) amount;
        if(quantity < 0) {
            throw new IllegalArgumentException("Invalid data for item.");
        }

        double Total = I.getPrice() * quantity;

        if(quantity > 4) {
            Total = (Total * 0.7);
        }

        Transaction transaction = new Transaction(ID, Total, amount);
        I.transactionList.add(transaction);
        final String transactionString = transaction.getID() +  ": " + transaction.getUnitsSold()  + " item(s). " + I.getPrice() + " SEK";
        I.transactionStringArray.add(transactionString);


        return Total;

    }

    public String createItem (String name, double price , String ID){
        String result = "";

        Item item = new Item (ID, name, price);

        if(price < 0 || ID.isEmpty() || name == "") {
            return "Invalid data for item.";
        }
        itemList.add(item);
        return ("Item " + item.getId() + " was registered successfully.");


    }

    // Simple add item method
    public void addItem(Item newItem) {

        //Item item = new Item(String Name, double Price, int ID);
        itemList.add(newItem);
    }

    // ##  I did changes to 2.5; 2.6; 2.7
    //remove items - 2.5
    public String removeItem (){

        String inputID = UserInput.readString("Enter the desired ID: ");
        Item inputItem = getItemByID(inputID);

        boolean checker = itemList.remove(inputItem);

        if (checker) {
            return ("Item " + inputItem.getId() + " was successfully removed");
        }

        else{
            return ("Item" + inputID + "could not be removed.");
        }

    }


    //print specific item? - 2.6

    public String printSpecificItem(String ID) {
        Item item = getItemByID(ID);
        String result = "";

        if (returnNotRegistered(ID)) {
            result = ("Item " + ID + " was not registered yet.");
        } else {

            //rounding steps, to 2nd decimal; ASK DYLAN!!!!!
            double priceOfItem = item.getPrice();
            double scale = Math.pow(10, 2);
            double roundingThePrice = Math.round(priceOfItem * scale) / scale;
            roundingThePrice = priceOfItem;

            result = (item.getId() + ":" + item.getName() + "  " + priceOfItem + "SEK.");

        }

        return result;
    }
    //print all registered items - 2.7
    //we cannot put prints on other classes that are not main so
    //this may need to be changed into a return statement using a toString()

    public void printAllItems() {
        System.out.println("All registered items:");

        if (itemList.isEmpty()) {
            System.out.println("No items registered yet.");

        } else {

            for (Item item : itemList) {
                System.out.println(item.getId() + ": " + item.getName() + ". " + item.getPrice() + "SEK");
            }

        }
    }//method transaction menu
    public void totalProfitFromAllItemsPurchased() {
        double totalProfit = 0;
        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            double specificPrice = item.getPrice();
            totalProfit += specificPrice;
        }
        System.out.println(totalProfit);

    }


    //3.1 - Nia

    //method creating reviews
    //the need of a scanner?
    public void createReviews(String ID) {

        //Pass these inputs to the menu class
        int grade = UserInput.readInt("You can choose a grade for your review between 1 to 5. Please, type your grade here:");

        String writtenComment = UserInput.readString("Optionally, you can add a written comment if you'd like:");

        Item item = getItemByID(ID);
        if (item == null ) {
            System.out.println("Item" + ID + "was not registered yet.");

        } else {
            System.out.println("Your review was registered successfully.");

            int i = item.grades.size();
            item.grades.add(i, grade);
            item.writtenComments.add(i, writtenComment);

            System.out.println("Your review was registered successfully.");
        }

    }
    //3.2 - Nia
    //print a specific item review

    public void printSpecificItemReview(String ID){
        //specifying the item ID
        //index of the desired review - from 1(first item's review)

        int i = UserInput.readInt("Type the index of the desired review: \n" +"" +
                "*This means if you want to get an item's first review, you should type 1*");

        Item item = getItemByID(ID);

        if (item == null){
            System.out.println("Item" + ID + "was not registered yet");
        }
        if(item.grades.size() == 0 && item.writtenComments.size() == 0){
            System.out.println("Item" + item.getName() + "has not been reviewed yet.");
        }

        else if(i < 1) {
            System.out.println("Invalid review number. Choose between 1 and" + " " + item.grades.size());

        }else{
            System.out.println("Grade:" + " " + item.grades.get(i) + "." + item.writtenComments.get(i));

        }

    }

    //3.3 - Nia
    public void printAllReviewsForAnItem(String ID){

        Item item = getItemByID(ID);

        if(item == null){
            System.out.println("Item" + ID + "was not registered yet.");
        }
        else if (item.grades.size() == 0 && item.writtenComments.size() == 0){
            System.out.println("Review(s) for " + ID + ": " + item.getName() + ". " + item.getPrice() + "SEK.\n" +
                    "Item " + item.getName() + " has not been reviewed yet." );
        }

        else{
            System.out.println("Review(s) for "  + ID + ": " + item.getName() + ". " + item.getPrice() + "SEK.");

            for(int i = 0; i < item.grades.size(); i++) {
                System.out.println("Grade: " + item.grades.get(i) + "." + item.writtenComments.get(i));
            }

        }
    }


    //3.4 - Oscar
    public String retrieveMeanGradeItem(String inputID) {

        Item inputItem = getItemByID(inputID);
        if (inputItem == null){
            return ("Item " + inputID + " was not registered yet.");
        }

        else if(inputItem.grades.size() == 0) {
            return ("Item " + inputItem.name + " has not been reviewed yet");
        }

        else {
            double totalGrades = 0;
            for (int i = 0; i < inputItem.grades.size(); i++) {
                totalGrades += inputItem.grades.get(i);
            }
            double mean = (totalGrades/inputItem.grades.size())*Math.pow(10,1);
            return(String.valueOf(mean));
        }

    }

    //3.5 - Oscar
    public String retrieveCommentsItem(String inputID){

        Item inputItem = getItemByID(inputID);

        if (inputItem == null || inputItem.writtenComments.size() == 0){
            return "Empty Collection";
        }

        else {
            String result = "";
            for (int i = 0; i < inputItem.writtenComments.size(); i++) {
                result += inputItem.writtenComments.get(i) + "\n";
            }

            return result;
        }
    }

    //3.6 - Oscar

    public String retrieveRegisteredReviews() {
        int noReviewedItem = 0;
        String result = "All registered reviews: \n"
                        + "- \n";

        if (itemList.size() == 0) {
            return "No items registered yet";
        }

        else {
            for (Item item : itemList) {
                if ((item.writtenComments.size()==0 || item.writtenComments.isEmpty()) && item.grades.size() == 0) {
                    noReviewedItem ++;
                    //checking if all items have not been reviewed, if this variable
                    //equals the size of the ItemList means that no Items were reviewed
                }

                else {
                    result += "Review(s) for " + item.ID + ": " + item.name + ". " + item.price + " SEK + \n";
                    for (int j= 0; j < item.grades.size(); j ++) {
                        result += "Grade: " + item.grades.get(j) + "."+ item.writtenComments.get(j);
                    }

                }
                result += '-';
            }

            if (noReviewedItem == itemList.size()){
                return ("No items were reviewed yet");
            }
            else{
                return result;
            }
        }
    }



    public Item GetMostAndLeastReviewedItems(){
        Item min = itemList.get(0);
        Item max = itemList.get(0);

        int minIndex = 0;
        int maxIndex = 0;

        for(int i = 1; i < itemList.size(); i++){
            if(itemList.get(i).getReviewLength() < min.getReviewLength()){
                min = itemList.get(i);
                minIndex = i;
            }
            if(itemList.get(i).getReviewLength() > max.getReviewLength()){
                max = itemList.get(i);
                maxIndex = i;
            }
        }

        System.out.println("Most reviews: <num reviews> review(s) each.\n" +
                max.getId() +": " + max.getName()+ " " + max.getPrice() +" SEK\n" );

        System.out.println("Most reviews: <num reviews> review(s) each.\n" +
                min.getId() +": " + min.getName()+ " " + min.getPrice() +" SEK\n" );

        return max;


    }

    // 3.8 Print items with highest / lowest grades ~ Dylan
    public Item GetHighestGrade(){
        Item min = itemList.get(0);
        Item max = itemList.get(0);

        int minIndex = 0;
        int maxIndex = 0;

        for(int i = 1; i < itemList.size(); i++){
            if(itemList.get(i).getMeanGrade() < min.getMeanGrade()){
                min = itemList.get(i);
                minIndex = i;
            }
            if(itemList.get(i).getMeanGrade() > max.getMeanGrade()){
                max = itemList.get(i);
                maxIndex = i;
            }
        }



        return max;
    }

    public Item GetLowestGrade(){
        Item min = itemList.get(0);
        Item max = itemList.get(0);

        int minIndex = 0;
        int maxIndex = 0;

        for(int i = 1; i < itemList.size(); i++){
            if(itemList.get(i).getMeanGrade() < min.getMeanGrade()){
                min = itemList.get(i);
                minIndex = i;
            }
            if(itemList.get(i).getMeanGrade() > max.getMeanGrade()){
                max = itemList.get(i);
                maxIndex = i;
            }
        }
        return min;

    }

    //4.1 - Nia and Oscar - Implemented in buy product method

    //4.2








}





