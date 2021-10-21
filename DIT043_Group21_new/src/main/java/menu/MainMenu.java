package menu;

import helpers.UserInput;

public class MainMenu {
    public static void printMainMenu() {
        System.out.println("Main Menu: Please choose among the options below.\n" + "\n" +
                "0. Close system.\n" +
                "1. Open Item options.\n" +
                "2. Open Review options.\n" +
                "3. Open Transaction History options.\n" +
                "4. Open Employee Options." +
                "\n" +
                "Type an option number:\n");
    }

    public static void MainMenuOptions(int option) {
        int choice;
        printMainMenu();
        switch (option) {
            case 0:
                System.exit(1); //check which exit status to use

            case 1:
                ItemMenu.printItemOptionsMenu();
                choice = UserInput.readInt("Enter your choice: "); // new change
                ItemMenu.ItemOptionsMenu(choice);
                break;
            case 2:
                ReviewsMenu.printReviewsOptionsMenu();
                 choice = UserInput.readInt("Enter your choice: "); // new change
                ReviewsMenu.ReviewsOptionsMenu(choice);

                break;
            case 3:
                TransactionMenu.printTransactionsHistoryOptionsMenu();
                choice = UserInput.readInt("Enter your choice: ");
                TransactionMenu.TransactionsHistoryOptionsMenu(choice);

                break;

            default:
                System.out.println("Invalid menu option. Please type another option");
                break;
        }
    }
}
