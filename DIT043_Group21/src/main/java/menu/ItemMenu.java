package menu;

import helpers.UserInput;
public class ItemMenu {
    public static void printItemOptionsMenu() {
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
    public void ItemOptionsMenu(int option) {
        switch (option) {
            case 0:
                //printMainMenu();
                //connect menus later;
                break;
            case 1:
                //METHOD FOR CREATING AN ITEM
                String Name = UserInput.readString("Specify the name of the item: ");
                double Price = UserInput.readDouble("Specify the price of the item: ");
                String ID = UserInput.readString("Specify the ID of the item: ");

                //items.createItem(Name, Price, ID);

                //We need to change this option, makes no sense at all cause we need do this in the buy product function
                //Create do whiles for the menus
                break;

            case 2:
                String inputID = UserInput.readString("Enter the desired ID");
              //  items.removeItem(inputID);
                break;

            case 3:
             //   items.printAllItems();
                break;

            case 4:
                ID = UserInput.readString("Enter the desired ID: ");
                int amount = UserInput.readInt("Enter the amount of Items you want to shop: ");
             //   items.buyItems(ID , amount); //we shouldnt specify the type when adding paratemers to an already created method
                break;

            case 5:
                //Find the specific item from all items by ID,
                String itemID = UserInput.readString("Specify the ID of the item: ");
                String newName = UserInput.readString("Specify the new name of the item: ");
                //item.updateNameItem(newName, itemID);
                break;
            case 6:
                //Find the specific item from all items by ID,
                //Call the item.Update method
                double newPrice = UserInput.readDouble("Specify the new price of the item: ");
            //    item.updatePriceItem(newPrice);
                break;
            default:
                System.out.println("Invalid menu option. Please type another option");
                break;
        }
    }
}
