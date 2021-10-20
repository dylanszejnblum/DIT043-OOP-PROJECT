import helpers.UserInput;

public class Main {
    public static void main(String []args){
        menu.MainMenu.printMainMenu();
        int choice = UserInput.readInt("Enter your choice: "); // new change
        menu.MainMenu.MainMenuOptions(choice);
    }
}
