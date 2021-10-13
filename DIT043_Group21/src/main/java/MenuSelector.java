public class MenuSelector {

    public Items items = new Items();
    public Item item;


    //1.1 - printing method for our Main Menu
    public void printMainMenu() {
        System.out.println("Main Menu: Please choose among the options below.\n" + "\n" +
                "0. Close system.\n" +
                "1. Open Item options.\n" +
                "2. Open Review options.\n" +
                "3. Open Transaction History options.\n" + "\n" + "\n" +
                "Type an option number:\n");
    }


    //1.2 - printing method for our Item Options Menu
    public void printItemOptionsMenu() {
        System.out.println("Item options menu:\n" +
                "0. Return to Main Menu.\n" +
                "1. Create an Item.\n" +
                "2. Remove an Item.\n" +
                "3. Print all registered Items.\n" +
                "4. Buy an Item.\n" +
                "5. Update an item’s name.\n" +
                "6. Update an item’s price.\n" +
                "\n" +
                "Type an option number:\n" + " ");

    }

    //1.3 - printing method for our Reviews Options Menu
    public void printReviewsOptionsMenu() {
        String text = "Reviews options menu:\n" +
                "0. Return to Main Menu.\n" +
                "1. Create a review for an Item.\n" +
                "2. Print a specific review of an Item.\n" +
                "3. Print all reviews of an Item.\n" +
                "4. Print mean grade of an Item\n" +
                "5. Print all comments of an Item.\n" +
                "6. Print all registered reviews.\n" +
                "7. Print item(s) with most reviews.\n" +
                "8. Print item(s) with least reviews.\n" +
                "9. Print item(s) with best mean review grade.\n" +
                "10. Print item(s) with worst mean review grade.\n" +
                "\n Type an option number:";


    }

    //1.4 - printing method for our Transactions History Options Menu
    public void printTransactionsHistoryOptionsMenu() {
        System.out.println("Transaction History options menu:\n" +
                "0. Return to Main Menu.\n" +
                "1. Print total profit from all items purchases\n" +
                "2. Print total units sold from all item purchases\n" +
                "3. Print the total number of item transactions made.\n" +
                "4. Print all transactions made.\n" +
                "5. Print the total profit of a specific item.\n" +
                "6. Print the number of units sold of a specific item.\n" +
                "7. Print all transactions of a specific item.\n" +
                "8. Print item with highest profit.\n" + "\n" +
                "Type an option number:");


    }

    //1.5 - method for the transaction from our MainMenu to the other Menus based on the user's input
    public void MainMenuOptions(int option) {
        switch (option) {
            case 0:
                System.exit(1); //check which exit status to use

            case 1: //open item options menu
                printItemOptionsMenu();
                break;
            case 2: //review options menu
                printReviewsOptionsMenu();
                break;
            case 3: //transaction history options menu
                printTransactionsHistoryOptionsMenu();
                break;

            default:
                System.out.println("Invalid menu option. Please type another option");
                break;
        }
    }

    //method for the transaction from our ItemOptionsMenu to the other Menus based on the user's input
    public void ItemOptionsMenu(int option) {
        switch (option) {
            case 0:
                printMainMenu();
                break;
            case 1:
                //METHOD FOR CREATING AN ITEM
                String Name = UserInput.readString("Specify the name of the item: ");
                double Price = UserInput.readDouble("Specify the price of the item: ");
                int ID = UserInput.readInt("Specify the ID of the item: ");
                items.createItem(Name, Price, ID);

                //We need to change this option, makes no sense at all cause we need do this in the buy product function
                //Create do whiles for the menus
                break;

            case 2:
                items.removeItem();
                break;

            case 3:
                items.printAllItems();
                break;

            case 4:
                ID = UserInput.readInt("Enter the desired ID: ");
                int amount = UserInput.readInt("Enter the amount of Items you want to shop: ");
                items.BuyItems(ID , amount); //we shouldnt specify the type when adding paratemers to an already created method
                break;

            case 5:
                //Find the specific item from all items by ID,
                Name = UserInput.readString("Specify the new name of the item: ");
                item.UpdateNameItem( Name);
                break;
            case 6:
                //Find the specific item from all items by ID,
                //Call the item.Update method
                Price = UserInput.readDouble("Specify the new price of the item: ");
                item.UpdatePriceItem( Price);
                break;
            default:
                System.out.println("Invalid menu option. Please type another option");
                break;
        }
    }


    //method for the transaction from our ReviewsOptionsMenu to the other Menus based on the user's input
    public void ReviewsOptionsMenu(int option) {
        //case1? Isn't it create a review for an Item?
        switch(option) {
            case 0:
                printMainMenu();
                break;

            case 1:
                printItemOptionsMenu();
                break;
            case 2:
                System.out.println("You choose the second option");
                break;
            case 3:
                System.out.println("You choose the third option");
                break;
            case 4:
                System.out.println("You choose the fourth option");
                break;
            case 5:
                System.out.println("You choose the fifth option");
                break;
            case 6:
                System.out.println("You choose the sixth option");
                break;
            case 7:
                System.out.println("You choose the seventh option");
                break;
            case 8:
                System.out.println("You choose the eigth option");
                break;
            case 9:
                System.out.println("You choose the nineth option");
                break;
            case 10:
                System.out.println("You choose the tenth option");
                break;
            default:
                System.out.println("Invalid menu option. Please type another option");
                break;
        }
    }
    //method for the transaction from our TransactionsHistoryOptionsMenu to the other Menus based on the user's input
    public void TransactionsHistoryOptionsMenu(int option){
        switch(option){
            case 0:
                printMainMenu();
                break;
            case 1:
                System.out.println("You choose the second option");
                break;
            case 2:
                System.out.println("You choose the third option");
                break;
            case 3:
                System.out.println("You choose the fourth option");
                break;
            case 4:
                System.out.println("You choose the fifth option");
                break;
            case 5:
                System.out.println("You choose the sixth option");
                break;
            case 6:
                System.out.println("You choose the seventh option");
                break;
            case 7:
                System.out.println("You choose the eight option");
                break;
            case 8:
                System.out.println("You choose the ninth option");
                break;
            default:
                System.out.println("Invalid menu option. Please type another option");
                break;

        }
    }



}