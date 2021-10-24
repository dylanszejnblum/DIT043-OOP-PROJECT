package menu;

import controllers.StoreController;
import helpers.UserInput;

public class ItemMenu {

    private static StoreController storeController = new StoreController();

    public static void printItemOptionsMenu() {
        System.out.println("Item options menu:\n" +
                "0. Return to Main Menu.\n" +
                "1. Create an Item.\n" +
                "2. Remove an Item.\n" +
                "3. Print all registered Items.\n" +
                "4. Buy an Item.\n" +
                "5. Update an item’s name.\n" +
                "6. Update an item’s price.\n" +
                "7. Print a specific item.\n" +
                "\n");

    }
    public static void ItemOptionsMenu(int option, StoreController storeController) {

        String itemID;

        do {
            switch (option) {
                case 0:
                    break;
                case 1:
                    itemID = UserInput.readString("Specify the ID of the item: ");
                    String name = UserInput.readString("Specify the name of the item: ");
                    double price = UserInput.readDouble("Specify the price of the item: ");
                    storeController.createValidItem(itemID, name, price);
                    System.out.println("Item was created successfully.");
                    printItemOptionsMenu();
                    option = UserInput.readInt("Enter your choice: ");
                    break;

                case 2:
                    itemID = UserInput.readString("Enter the desired ID");
                    storeController.removeValidItem(itemID);
                    System.out.println("Item was removed successfully.");
                    printItemOptionsMenu();
                    option = UserInput.readInt("Enter your choice: ");
                    break;

                case 3:
                    System.out.println(storeController.printAllItems());
                    printItemOptionsMenu();
                    option = UserInput.readInt("Enter your choice: ");
                    break;

                case 4:
                    itemID = UserInput.readString("Enter the desired ID: ");
                    int quantity = UserInput.readInt("Enter the amount of Items you want to buy: ");
                    storeController.buyItem(itemID, quantity);
                    System.out.println("Item was bought successfully.");
                    printItemOptionsMenu();
                    option = UserInput.readInt("Enter your choice: ");
                    break;

                case 5:
                    //Find the specific item from all items by ID,
                    itemID = UserInput.readString("Specify the ID of the item: ");
                    String newName = UserInput.readString("Specify the new name of the item: ");
                    storeController.updateNameItem(itemID, newName);
                    System.out.println("Item's name was updated successfully.");
                    printItemOptionsMenu();
                    option = UserInput.readInt("Enter your choice: ");
                    break;
                case 6:
                    itemID = UserInput.readString("Specify the ID of the item: ");
                    double newPrice = UserInput.readDouble("Specify the new price of the item: ");
                    storeController.updateItemPrice(itemID, newPrice);
                    System.out.println("Item's name was updated successfully.");
                    printItemOptionsMenu();
                    option = UserInput.readInt("Enter your choice: ");
                    break;

                case 7:
                    itemID = UserInput.readString("Specify the ID of the item: ");
                    System.out.println(storeController.printSpecificItem(itemID));
                    printItemOptionsMenu();
                    option = UserInput.readInt("Enter your choice: ");
                    break;

                default:
                    System.out.println("Invalid menu option. Please type another option");
                    option = UserInput.readInt("Enter your choice: ");
                    break;
            }

        }while(option != 0);

    }
}
