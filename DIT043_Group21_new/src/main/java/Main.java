import helpers.UserInput;

public class Main {

    public static void main(String []args) throws Exception {
        menu.MainMenu.printMainMenu();
        int choice = UserInput.readInt("Enter your choice: ");
        menu.MainMenu.mainMenuOptions(choice);
    }
}
