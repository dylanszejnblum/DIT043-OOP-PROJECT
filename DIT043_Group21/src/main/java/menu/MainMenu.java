package menu;
import helpers.UserInput;

public class MainMenu {
    public void printMainMenu() {
        System.out.println("Main Menu: Please choose among the options below.\n" + "\n" +
                "0. Close system.\n" +
                "1. Open Item options.\n" +
                "2. Open Review options.\n" +
                "3. Open Transaction History options.\n" + "\n" + "\n" +
                "Type an option number:\n");
    }
    public void MainMenuOptions(int option) {
        switch (option) {
            case 0:
                System.exit(1); //check which exit status to use

            case 1: //open item options menu
                //printItemOptionsMenu();
              //  Import item menu
                break;
            case 2: //review options menu
            //printReviewsOptionsMenu();
                //  Import review menu

                break;
            case 3: //transaction history options menu
             //   printTransactionsHistoryOptionsMenu();
                // import transaction history menu
                break;

            default:
                System.out.println("Invalid menu option. Please type another option");
                break;
        }
    }

}
