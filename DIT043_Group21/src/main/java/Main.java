public class Main {
    public static void main(String[] args) {

        MenuSelector menuSelector = new MenuSelector();
        //int choice = -1;
        // Base line menu for the rest of tasks.
        // Open scanner
        //Scanner scanner = new Scanner(System.in);

        //calling our printing MainMenu method

        menuSelector.printMainMenu();
        int choice = UserInput.readInt("Enter your choice: "); // new change
        menuSelector.MainMenuOptions(choice);
    }
}
