package menu;
import helpers.UserInput;

public class ReviewMenu {
    public static void printReviewsOptionsMenu() {
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
    public void ReviewsOptionsMenu(int option) {
        //case1? Isn't it create a review for an Item?
        switch(option) {
            case 0:
               // printMainMenu();
                break;

            case 1:
             //   printItemOptionsMenu();
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
                System.out.println("You choose the eighth option");
                break;
            case 9:
                System.out.println("You choose the ninth option");
                break;
            case 10:
                System.out.println("You choose the tenth option");
                break;
            default:
                System.out.println("Invalid menu option. Please type another option");
                break;
        }
    }
}
