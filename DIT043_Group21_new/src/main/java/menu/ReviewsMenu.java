package menu;

import controllers.EmployeeController;
import controllers.StoreController;
import helpers.UserInput;
import primitives.Item;

public class ReviewsMenu {
    public static void printReviewsOptionsMenu() {
        System.out.println("Reviews options menu:\n" +
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
                "10. Print item(s) with worst mean review grade.\n");

    }
    public static void ReviewsOptionsMenu(int option, StoreController storeController) {
        int choice;
        String writtenComment;
        String ID;
        int grade;
        Item item;
        do {
            switch (option) {
                case 0:
                    break;

                case 1:
                    ID = UserInput.readString("Introduce the desired ID: ");
                    writtenComment = UserInput.readString("Introduce the desired comment: ");
                    grade = UserInput.readInt("Introduce the desired grade (1-5): ");
                    storeController.createReviews(ID, writtenComment, grade);
                    System.out.println("Review was created successfully.");
                    printReviewsOptionsMenu();
                    choice = UserInput.readInt("Enter your choice: ");
                    ItemMenu.ItemOptionsMenu(choice, storeController);
                    break;

                case 2:
                    ID = UserInput.readString("Introduce the desired ID: ");
                    item = storeController.getItemById(ID);
                    int numberOfReviews = item.reviews.size()-1;
                    if (numberOfReviews <0){
                        numberOfReviews = 0;
                    }
                    int reviewIndex = UserInput.readInt("Introduce the number of the desired review (0-"+ numberOfReviews+"): ");
                    storeController.printSpecificItemReview(ID, reviewIndex);
                    System.out.println("Review was created successfully.");
                    printReviewsOptionsMenu();
                    choice = UserInput.readInt("Enter your choice: ");
                    ItemMenu.ItemOptionsMenu(choice, storeController);
                    break;

                case 3:
                    ID = UserInput.readString("Introduce the desired ID: ");
                    item = storeController.getItemById(ID);
                    System.out.println(item.printAllReviews());
                    printReviewsOptionsMenu();
                    choice = UserInput.readInt("Enter your choice: ");
                    ItemMenu.ItemOptionsMenu(choice, storeController);
                    break;

                case 4:
                    ID = UserInput.readString("Introduce the desired ID: ");
                    double mean = storeController.getMeanItemGrade(ID);
                    System.out.println("Mean grade: " + mean);
                    printReviewsOptionsMenu();
                    choice = UserInput.readInt("Enter your choice: ");
                    ItemMenu.ItemOptionsMenu(choice, storeController);
                    break;

                case 5:
                    ID = UserInput.readString("Introduce the desired ID: ");
                    item = storeController.getItemById(ID);
                    System.out.println("Comments: ");
                    System.out.println(item.printAllComments());
                    printReviewsOptionsMenu();
                    choice = UserInput.readInt("Enter your choice: ");
                    ItemMenu.ItemOptionsMenu(choice, storeController);
                    break;

                case 6:
                    System.out.println(storeController.printAllReviews());
                    printReviewsOptionsMenu();
                    choice = UserInput.readInt("Enter your choice: ");
                    ItemMenu.ItemOptionsMenu(choice, storeController);
                    break;

                case 7:
                    System.out.println(storeController.printMostReviewedItems());
                    printReviewsOptionsMenu();
                    choice = UserInput.readInt("Enter your choice: ");
                    ItemMenu.ItemOptionsMenu(choice, storeController);
                    break;

                case 8:
                    System.out.println(storeController.printLeastReviewedItems());
                    printReviewsOptionsMenu();
                    choice = UserInput.readInt("Enter your choice: ");
                    ItemMenu.ItemOptionsMenu(choice, storeController);
                    break;

                case 9:
                    System.out.println(storeController.printBestMeanReviews());
                    printReviewsOptionsMenu();
                    choice = UserInput.readInt("Enter your choice: ");
                    ItemMenu.ItemOptionsMenu(choice, storeController);
                    break;

                case 10:
                    System.out.println(storeController.printWorseMeanReviews());
                    printReviewsOptionsMenu();
                    choice = UserInput.readInt("Enter your choice: ");
                    ItemMenu.ItemOptionsMenu(choice, storeController);
                    break;

                default:
                    System.out.println("Invalid menu option. Please type another option");
                    option = UserInput.readInt("Enter your choice: ");
                    break;
            }

        }while(option != 0);

}}
