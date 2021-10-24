package controllers;

import helpers.MathHelpers;
import primitives.Employee;
import primitives.Item;
import primitives.Review;
import primitives.Transaction;
import primitives.ItemTransactionIndex;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class StoreController {
    public ArrayList<Employee> employees;
    ArrayList<Item> items;
    ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    ArrayList<ItemTransactionIndex> profitList;
    public Item item;
    public Review review;


    public StoreController(){
        items = new ArrayList<Item>();
        transactions = new ArrayList<Transaction>();
        profitList = new ArrayList<ItemTransactionIndex>();
    }

    public boolean itemExistenceChecker(String ID){
        for (Item item : items) {
            if (item.getId().equals(ID)) {
                return true;
            }
        }
        return false;
    }

    public boolean itemExists(String ID){
        for(int i = 0 ; i< items.size(); i++){
            Item n = items.get(i);
            if(n.getId().equals(ID)){
                return true;
            }
        }
        return false;
    }

    public double totalPurchases(){
        double total = 0;
        for(Transaction a : transactions){
            total = total + a.getPrice();
        }

        return MathHelpers.truncateDouble(total);
    }

    public int totalUnits(){
        int units = 0;
        for(int i = 0; i < transactions.size();i++){
            units += transactions.get(i).getAmount();
        }
        return units;
    }

    public int totalTransaction(){
        return transactions.size();

    }

    public double getSpecificItemProfit(String ID){
        double profit = 0;
        if(itemExists(ID)){
            for(int i = 0; i < transactions.size();i++){
                if(ID.equals(transactions.get(i).getId())) {
                    profit += transactions.get(i).getPrice();
                }
            }
            return MathHelpers.truncateDouble(profit);
        }
        return profit;
    }
    public int getSpecificUnitsSold(String ID){
        int unitSold = 0;
        if(itemExists(ID)){
            for(int i = 0; i < transactions.size();i++){
                if(ID.equals(transactions.get(i).getId())) {
                    unitSold += transactions.get(i).getAmount();
                }
            }
            return unitSold;
        }
        return unitSold;

    }
    public int getSpecificTransactions(String ID){
        int transactionCount = 0;
        if(itemExists(ID)){
            for(int i = 0; i < transactions.size();i++){
                if(ID.equals(transactions.get(i).getId())) {
                    transactionCount++;
                }
            }
            return transactionCount;
        }
        return transactionCount;

    }






    public String getAllItemTransactions(String ID){
        if(itemExists(ID) == false) {
            return ("Item "+ ID +" was not registered yet.");
        }
        Item specificItem = getItemById(ID);
        String result = ("Transactions for item: " + specificItem.getId() + ": " + specificItem.getName() +". " + specificItem.getPrice() + " SEK\n");
        int transactionCount = 0;
        for(int i = 0 ; i < transactions.size();i++){
            if(ID.equals(transactions.get(i).getId())){
                result +=  transactions.get(i).toString() + "\n";
                transactionCount++;
            }
        }
        if(transactionCount == 0){
            DecimalFormat df = new DecimalFormat("0.00");

            return "Transactions for item: "+ specificItem.getId() +": "+specificItem.getName() + ". "+ df.format(specificItem.getPrice()) + " SEK\n" +
                    "No transactions have been registered for item "+ specificItem.getId()+" yet.";
        }
        return result;




    }
    public Item getItemById(String id){
        for(int i =0  ; i < items.size() ; i++){
            if(items.get(i).getId().equals(id)){
                return items.get(i);
            }
        }
        return null;
    }

    public String createValidItem (String ID, String name , double price){
        if(price < 0 || ID.isEmpty() || name.isEmpty()) {
            return "Invalid data for item.";
        }

        Item item = new Item (ID, name, price);
        items.add(item);
        return ("Item " + ID + " was registered successfully.");
    }

    public String removeValidItem (String inputID){
        ArrayList<Item> copyItems = new ArrayList<>();
        boolean checker = false;
        for (int i = 0; i < items.size(); i++) {
            if (!items.get(i).getId().equals(inputID)) {
                copyItems.add(items.get(i));
            }
            else{
                checker = true;
            }
        }
        if (checker) {
            items = copyItems;
            return ("Item " + inputID + " was successfully removed.");
        }
        else{
            return ("Item " + inputID + " could not be removed.");
        }

    }
    public String updateItemPrice( String ID  ,double newPrice) {
        DecimalFormat df = new DecimalFormat("0.00");
        if(itemExistenceChecker(ID) != true){
            return  "Item " + ID + " was not registered yet.";
        }
        else if (ID.isEmpty() ||newPrice <= 0) {
            return "Invalid data for item.";
        }
        else {
            Item inputItem = getItemById(ID);
            inputItem.setPrice(newPrice);
            return  "Item " + inputItem.getId() + " was updated successfully.";
        }
    }

    public String printAllTransactions(){
        DecimalFormat df = new DecimalFormat("0.00");
        String result = "All purchases made: " + "\n" + "Total profit: " + df.format(totalPurchases()) + " SEK\n" + "Total items sold: "+ totalUnits()+" units\n" + "Total purchases made: " + totalTransaction()+  " transactions\n"+ "------------------------------------\n";
        if(transactions.isEmpty() == false){
            for(Transaction n : transactions){
                result += n.toString()+ "\n";
            }
            return  result + "------------------------------------\n";
        }else{
            return  result + "------------------------------------\n";
        }

    }


    public  void addAllItemsProffit(){
        if(items.isEmpty() == false && transactions.isEmpty() == false){
            for(Item n : items){
                double nProfit = getSpecificItemProfit(n.getId());
                ItemTransactionIndex foo = new ItemTransactionIndex(n.getId() , nProfit);
                profitList.add(foo);
            }
        }
    }

    public String printMostProfitable(){
        DecimalFormat df = new DecimalFormat("0.00");
        addAllItemsProffit();

        ItemTransactionIndex min = profitList.get(0);
        ItemTransactionIndex max = profitList.get(0);
        int size = profitList.size();

        for(int i = 1;  i < size; i++){
            if(profitList.get(i).profit > max.profit){
                max = profitList.get(i);
            }
        }

        Item MostProfitable = getItemById(max.getID());
        return "Most profitable items: \n" + "Total profit: "+ df.format(max.profit) +" SEK\n" + MostProfitable.toString()+"\n";




    }
    public String updateNameItem( String ID  ,String newName) {
        if(itemExistenceChecker(ID) != true){
            return  "Item " + ID + " was not registered yet.";
        }
        else if (ID.isEmpty() ||newName.isEmpty()) {
            return "Invalid data for item.";
        }
        else {
            Item inputItem = getItemById(ID);
            inputItem.setName(newName);
            return  "Item " + inputItem.getId() + " was updated successfully.";
        }
    }

    public String getAllItems(){
        for (Item item : items) {
            System.out.println(item.toString());
        }
        return null;
    }

    public void sortItemsDecendingMeanReview(){
        Item temp ;
        for(int a = 0; a < items.size(); a++)
        {
            for(int b = a + 1; b < items.size(); b++)
            {
                if(items.get(a).getMeanReview() > items.get(b).getMeanReview())
                {
                    temp = items.get(a);
                    items.set(a,items.get(b));
                    items.set(b , temp);
                }
            }
        }
    }
    public void sortItemsAscendingMeanReview(){
        Item temp ;
        for(int a = 0; a <= items.size() - 1; a++) {
            for (int b = 0; b <= items.size() - 2; b++)
                if (items.get(b).getMeanReview() < items.get(b + 1).getMeanReview()) {

                    temp = items.get(b);
                    int c = b + 1;
                    items.set(b, items.get(b + 1));
                    items.set((b + 1), temp);
                }
        }
    }

    public void sortItemsDescendingMeanReview(){
        sortItemsAscendingMeanReview();
        ArrayList<Item> descendingItems = new ArrayList<>();
        ArrayList<Item> withoutReviewsItems = new ArrayList<>();
        for (int i = items.size()-1; i >=0; i--){
            if (items.get(i).reviews.size()>0) {
                descendingItems.add(items.get(i));
            }
            else {
                withoutReviewsItems.add(items.get(i));
            }
        }
        if (withoutReviewsItems.size()> 0){
            descendingItems.addAll(withoutReviewsItems);
        }
        items = descendingItems;
    }




    public void sortItemsDescendingReviewQuantity(){
        sortItemsAscendingReviewQuantity();
        ArrayList<Item> descendingItems = new ArrayList<>();
        ArrayList<Item> withoutReviewsItems = new ArrayList<>();
        for (int i = items.size()-1; i >=0; i--){
            if (items.get(i).reviews.size()>0) {
                descendingItems.add(items.get(i));
            }
            else {
                withoutReviewsItems.add(items.get(i));
            }
        }
        if (withoutReviewsItems.size()> 0){
            descendingItems.addAll(withoutReviewsItems);
        }
        items = descendingItems;


    }
    public void sortItemsAscendingReviewQuantity(){

        Item temp ;
        for(int a = 0; a <= items.size() - 1; a++)
        {
            for(int b = 0; b <= items.size() - 2; b++)
            {
                 if(items.get(b).reviews.size() < items.get(b + 1).reviews.size())
                {
                    temp = items.get(b);
                    int c = b+1;
                    items.set(b,items.get(b+1)) ;
                    items.set((b+1) , temp);
                }
            }
        }

    }

    public List<String> getItemsWithMostReviews(){
        sortItemsAscendingReviewQuantity();
        List <String> mostReviews = new ArrayList<String>();
        if (items.size() == 0 || (items.size()>0 && items.get(0).getNumberOfReviews() == 0)){
            return mostReviews;
        }
        Item firstItem = items.get(0);
        mostReviews.add(firstItem.getId());
        for(Item currentItem : items){
            if(currentItem.getId() != firstItem.getId() && currentItem.getNumberOfReviews() == firstItem.getNumberOfReviews()) {
                mostReviews.add(currentItem.getId());
            }
        }
        return mostReviews;
    }

    public String printMostReviewedItems(){

        String invalidItemsMessage = validateItems(items.size());
        if (!invalidItemsMessage.isEmpty()) {
            return invalidItemsMessage;
        }
        String invalidReviewsMessage = validateReviews(items);
        if (!invalidReviewsMessage.isEmpty()){
            return invalidReviewsMessage;
        }
        List <String> mostReviews = getItemsWithMostReviews();
        String Result = "Most reviews: " + getItemById(mostReviews.get(0)).getNumberOfReviews() + " review(s) each.\n";
        for(String id : mostReviews){
            Result += getItemById(id).toString() + "\n";

        }
        return Result;
    }

    public List<String> getItemsWithLeastReviews(){
        sortItemsDescendingReviewQuantity();
        List <String> leastReviews = new ArrayList<String>();

        if (items.size() == 0 || (items.size()>0 && items.get(0).getNumberOfReviews() == 0)){
            return leastReviews;
        }
        Item firstItem = items.get(0);
        leastReviews.add(firstItem.getId());
        for(Item currentItem : items){
            if(currentItem.getId() != firstItem.getId() && currentItem.getNumberOfReviews() == firstItem.getNumberOfReviews()) {
                leastReviews.add(currentItem.getId());
            }
        }


        return leastReviews;

    }

    public String printLeastReviewedItems(){
        String invalidItemsMessage = validateItems(items.size());
        if (!invalidItemsMessage.isEmpty()) {
            return invalidItemsMessage;
        }
        String invalidReviewsMessage = validateReviews(items);
        if (!invalidReviewsMessage.isEmpty()){
            return invalidReviewsMessage;
        }
        List <String> leastReviews = getItemsWithLeastReviews();
        String Result = "Least reviews: " + getItemById(leastReviews.get(0)).getNumberOfReviews() + " review(s) each.\n";
        for(String id : leastReviews){
            Result += getItemById(id).toString() + "\n";

        }
        return Result;
    }

    public List<String> getItemsWithBestMeanReviews(){
        sortItemsAscendingMeanReview();
        List <String> sortedIds = new ArrayList<String>();
        if (items.size() == 0 || (items.size()>0 && items.get(0).getNumberOfReviews() == 0)){
            return sortedIds;
        }
        Item firstItem = items.get(0);
        sortedIds.add(firstItem.getId());
        for(Item currentItem : items){
            if(currentItem.getId() != firstItem.getId() && currentItem.getMeanReview() == firstItem.getMeanReview()) {
                sortedIds.add(currentItem.getId());
            }
        }

        return sortedIds;
    }

    public List<String> getItemsWithWorseMeanReviews(){
        sortItemsDescendingMeanReview();
        List <String> sortedIds = new ArrayList<String>();
        if (items.size() == 0 || (items.size()>0 && items.get(0).getNumberOfReviews() == 0)){
            return sortedIds;
        }
        Item firstItem = items.get(0);
        sortedIds.add(firstItem.getId());
        for(Item currentItem : items){
            if(currentItem.getId() != firstItem.getId() && currentItem.getMeanReview() == firstItem.getMeanReview()) {
                sortedIds.add(currentItem.getId());
            }
        }

        return sortedIds;
    }

    public String printBestMeanReviews(){
        String invalidItemsMessage = validateItems(items.size());
        if (!invalidItemsMessage.isEmpty()) {
            return invalidItemsMessage;
        }
        String invalidReviewsMessage = validateReviews(items);
        if (!invalidReviewsMessage.isEmpty()){
            return invalidReviewsMessage;
        }
        List <String> bestMeanReviews = getItemsWithBestMeanReviews();
        String Result = "Items with best mean reviews:\n"+ "Grade: " + String.format("%.1f" ,getItemById(bestMeanReviews.get(0)).getMeanReview()) +"\n";
        for(String id : bestMeanReviews){
            Result += getItemById(id).toString() + "\n";

        }
        return Result;
    }

    public String printWorseMeanReviews(){
        String invalidItemsMessage = validateItems(items.size());
        if (!invalidItemsMessage.isEmpty()) {
            return invalidItemsMessage;
        }
        String invalidReviewsMessage = validateReviews(items);
        if (!invalidReviewsMessage.isEmpty()){
            return invalidReviewsMessage;
        }
        List <String> worseMeanReviews = getItemsWithWorseMeanReviews();
        String Result = "Items with worst mean reviews:\n"+ "Grade: " + getItemById(worseMeanReviews.get(0)).getMeanReview() +"\n";
        for(String id : worseMeanReviews){
            Result += getItemById(id).toString() + "\n";

        }
        return Result;
    }




    public String printSpecificItem(String ID) {
        // Dunno why but it's the only
        DecimalFormat df = new DecimalFormat("0.00");
        if (!itemExistenceChecker(ID)) {
            return("Item " + ID + " was not registered yet.");
        } else {
            Item item = getItemById(ID);
            return(item.getId() + ": " + item.getName() + ". " + df.format(item.getPrice()) + " SEK");
        }
    }


    // Not finished , it shoudl acomodate for the transactions class
    public double buyItem(String ID , int quantity){
        int discountedQuantity;
        Item BoughtItem = getItemById(ID);

        if (itemExistenceChecker(ID) == false){
            return  -1.0;
        } else if(quantity <= 4 && quantity > 0){
            double total = BoughtItem.getPrice() * (double) quantity;
            Transaction transaction = new Transaction(ID , quantity ,  total);
            transactions.add(transaction);

            return total;
        }
        else{
            double totalWithoutDiscount = BoughtItem.getPrice() * 4.0;


            double total = MathHelpers.truncateDouble((totalWithoutDiscount + (BoughtItem.getPrice() * (quantity-4)) * (1-0.3)));
            Transaction transaction = new Transaction(ID , quantity ,  total);
            transactions.add(transaction);
            return total ;
        }
        // need to add a -1 at the end
    }


    public String getSpecificItemReview(String ID , int index){
        Item n = getItemById(ID);
        return n.getSpecificReview(index);
    }

    public String getAllReviewsItem(String ID){
        Item n = getItemById(ID);
        return n.printAllReviews();
    }

    public String getAllReviews(){
        for(int i = 0; i< items.size();i++){
            System.out.println(items.get(i).printAllReviews());
        }
        return null;

    }


    // Add sorting functions

    // 3.1 - Nia

//method creating reviews

    public String createReviews(String ID , String writtenComment , int grade){
        String invalidIDMessage = validateID(ID);
        if (!invalidIDMessage.isEmpty()) {
            return invalidIDMessage;
        }
        String invalidGradeMessage = validateGrade(grade);
        if (!invalidGradeMessage.isEmpty()) {
            return invalidGradeMessage;
        }
        Item item = getItemById(ID);
        item.createReview(grade, writtenComment);
        return ("Your item review was registered successfully.");
    }
//3.2 - Nia
//print a specific item review


    public List<String> getItemComment(String ID){
        return getItemById(ID).printAllWrittenReviews();
    }

    public String printAllReviews(){
        String invalidItemsMessage = validateItems(items.size());
        if (!invalidItemsMessage.isEmpty()) {
            return invalidItemsMessage;
        }
        String invalidReviewsMessage = validateReviews(items);
        if (!invalidReviewsMessage.isEmpty()){
            return invalidReviewsMessage;
        }
        String result = "All registered reviews:\n" + "------------------------------------\n";
        for(Item item: items){
            if(item.reviews.isEmpty() == false) {
                result += item.getAllReviwewsForItem() + "------------------------------------\n";
            }
        }
        return result;
    }

    public String getReviewsForItem(String ID){
        String invalidItemMessage = validateItem(ID);
        if (!invalidItemMessage.isEmpty()) {
            return invalidItemMessage;
        }

        Item item = getItemById(ID);
        String invalidReviewMessage = validateReviewSize(item);
        if (!invalidReviewMessage.isEmpty()) {
            return invalidReviewMessage;
        }

        return getItemById(ID).getAllReviwewsForItem();
    }

    public String printSpecificItemReview(String ID,int i) {

        Item item = getItemById(ID);

        if (!itemExistenceChecker(ID)) {
            return "Item" + ID + " was not registered yet.";
        }
        else if (item.reviews.isEmpty()) {
            return "Item " + item.getName() + " has not been reviewed yet.";
        }
        else if (i < 1 || i > item.reviews.size()) {
            return "Invalid review  number. Choose between 1 and " + item.reviews.size();
        }
        return item.reviews.get(i-1).reviewToString();
    }


    //3.4 - Oscar

    public double getMeanItemGrade(String id){
        return getItemById(id).getMeanReview();
    }

    public int getItemReviewById(String ID){
        return getItemById(ID).getNumberOfReviews();
    }

    public String retrieveMeanGradeItem(String ID) {
        if (itemExistenceChecker(ID)){
            return ("Item " + ID + " was not registered yet.");
        }

        else if(item.reviews.isEmpty()) {
            Item inputItem = getItemById(ID);
            return ("Item " + inputItem.getName() + " has not been reviewed yet");
        }

        else {
            Item inputItem = getItemById(ID);
            double totalGrades = 0;
            for (int i = 0; i < item.reviews.size(); i++) {
                totalGrades += inputItem.reviews.get(i).getGrade();
            }
            double mean = (totalGrades/item.reviews.size())*Math.pow(10,1); //math pow useless here
            return(String.valueOf(mean));
        }

    }

    //3.5 - Oscar
    public String retrieveCommentsItem(String ID){

        Item inputItem = getItemById(ID);

        if (itemExistenceChecker(ID) || item.reviews.isEmpty()) {
            return "Empty Collection";
        }

        else {
            String result = "";
            for (int i = 0; i < item.reviews.size(); i++) {
                result += item.reviews.get(i).getWrittenReview() + "\n";
            }

            return result;
        }
    }

//3.6 - Oscar

    public String retrieveRegisteredReviews() {
        int noReviewedItem = 0;
        String result = "";

        if (items.size() == 0) {
            return "No items registered yet";
        }

        else {

            for (Item item : items) {
                if (item.reviews.size() == 0) {
                    noReviewedItem++;
                }
            }

            if (noReviewedItem == items.size()) {
                return ("No items were reviewed yet");
            } else {
                for (Item item : items) {
                    result = "--------------------------\n" + "Review(s) for " + item.getId() + ": " + item.getName() + ". " + item.getPrice() + " SEK + \n";

                    for (int j = 0; j < item.reviews.size(); j++) {
                        result += "Grade: " + item.reviews.get(j).getGrade() + "." + item.reviews.get(j).getWrittenReview();
                    }
                }
            }
        }

        return "All registered reviews:\n" + result;
    }


    public String getSpecificReviewFromItem(String ID , int reviewNumber){
        Item item = getItemById(ID);
        String name = item.getName();
        String invalidReviewSizeMessage = validateReviewSize(name, item.reviews.size());
        if (!invalidReviewSizeMessage.isEmpty()){
            return  invalidReviewSizeMessage;
        }
        String invalidReviewNumberMessage = validateReviewIndex(reviewNumber, item.reviews.size());
        if (!invalidReviewNumberMessage.isEmpty()){
            return  invalidReviewNumberMessage;
        }
        return getItemById(ID).getSpecificReview(reviewNumber);
    }

    public String printAllItems() {
        if (items.isEmpty()) {
            return "No items registered yet.";
        } else {


            String message = "All registered items:\n";
            for (Item item : items) {
                message += item.toString() + "\n";
            }
            return message;
        }
    }

    private String validateID(String ID) {
        if (!itemExists(ID)) {
            return "Item " + ID + " was not registered yet.";
        }
        return "";
    }


    private String validateGrade(int grade) {
        if (grade > 5 || grade < 1){
            return "Grade values must be between 1 and 5.";
        }
        return "";
    }

    private String validateReviewIndex(int index, int reviewsSize) {
        if (index > reviewsSize || index < 1){
            return "Invalid review number. Choose between 1 and " + reviewsSize+".";
        }
        return "";
    }

    private String validateReviewSize(String name, int reviewSize){
        if (reviewSize == 0){
            return "Item "+ name+ " has not been reviewed yet.";
        }
        return "";
    }

    private String validateReviewSize(Item item){

        if (item.reviews.size() == 0){
            String expectedNonReviewed = "Review(s) for "+ item.getId() + ": " + item.getName() + ". "+String.format("%.2f",item.getPrice()) + " SEK\n" +
                    "The item "+ item.getName() +" has not been reviewed yet.";
            return expectedNonReviewed;
        }
        return "";
    }

    private String validateItem(String ID){
        if (!itemExists(ID)) {
            return "Item " + ID + " was not registered yet.";
        }
        return "";
    }

    private String validateItems(int itemsListSize){
        if (itemsListSize == 0){
            return "No items registered yet.";
        }
        return  "";
    }

    private String validateReviews(List<Item> items) {
        for (Item currentItem : items){
            if (currentItem.reviews.size()>0){
                return "";
            }
        }
        return "No items were reviewed yet.";
    }




}

