package menu;

public class TransactionHistoryMenu {
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
                "8. Print item with highest profit.\n" + "\n" +
                "Type an option number:");
    }


        public void TransactionsHistoryOptionsMenu(int option){
        switch(option){
            case 0:
               // printMainMenu();
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

        }}
}
