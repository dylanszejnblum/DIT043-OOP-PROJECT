package menu;

import controllers.StoreController;
import helpers.UserInput;
import primitives.Item;

public class TransactionMenu {
    public static void printTransactionsHistoryOptionsMenu() {
        System.out.println("Transaction History options menu:\n" +
                "0. Return to Main Menu.\n" +
                "1. Print total profit from all items purchases\n" +
                "2. Print total units sold from all item purchases\n" +
                "3. Print the total number of item transactions made.\n" +
                "4. Print all transactions made.\n" +
                "5. Print the total profit of a specific item.\n" +
                "6. Print the number of units sold of a specific item.\n" +
                "7. Print all transactions of a specific item.\n" +
                "8. Print item with highest profit.\n");
    }


    public static void TransactionsHistoryOptionsMenu(int option, StoreController storeController){
        String ID;
        double totalPurchases;
        int totalSoldUnits;
        int totalTransactions;
        do {
            switch(option){
                case 0:
                    break;

                case 1:
                    totalPurchases = storeController.totalPurchases();
                    System.out.println("Total purchase: " + totalPurchases);
                    printTransactionsHistoryOptionsMenu();
                    option = UserInput.readInt("Enter your choice: ");
                    break;

                case 2:
                    totalSoldUnits = storeController.totalUnits();
                    System.out.println("Total sold units: " + totalSoldUnits);
                    printTransactionsHistoryOptionsMenu();
                    option = UserInput.readInt("Enter your choice: ");
                    break;

                case 3:
                    totalTransactions = storeController.totalTransaction();
                    System.out.println("Total transactions: " + totalTransactions);
                    printTransactionsHistoryOptionsMenu();
                    option = UserInput.readInt("Enter your choice: ");
                    break;

                case 4:
                    System.out.println(storeController.printAllTransactions());
                    printTransactionsHistoryOptionsMenu();
                    option = UserInput.readInt("Enter your choice: ");
                    break;

                case 5:
                    ID = UserInput.readString("Introduce the desired ID: ");
                    System.out.println("Total item profit: " + storeController.getSpecificItemProfit(ID));
                    printTransactionsHistoryOptionsMenu();
                    option = UserInput.readInt("Enter your choice: ");
                    break;

                case 6:
                    ID = UserInput.readString("Introduce the desired ID: ");
                    System.out.println("Total item units sold: " + storeController.getSpecificUnitsSold(ID));
                    printTransactionsHistoryOptionsMenu();
                    option = UserInput.readInt("Enter your choice: ");
                    break;

                case 7:
                    ID = UserInput.readString("Introduce the desired ID: ");
                    System.out.println(storeController.getAllItemTransactions(ID));
                    printTransactionsHistoryOptionsMenu();
                    option = UserInput.readInt("Enter your choice: ");
                    break;

                case 8:
                    System.out.println(storeController.printMostProfitable());
                    printTransactionsHistoryOptionsMenu();
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
