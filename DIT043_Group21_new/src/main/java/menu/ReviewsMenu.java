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
                    option = UserInput.readInt("Enter your choice: ");
                    break;

                case 2:
                    ID = UserInput.readString("Introduce the desired ID: ");
                    item = storeController.getItemById(ID);
                    int numberOfReviews = item.reviews.size();
                    if (numberOfReviews ==0){
                        numberOfReviews = 1;
                    }
                    int reviewIndex = UserInput.readInt("Introduce the number of the desired review (1-"+ numberOfReviews+"): ");
                    System.out.println(storeController.printSpecificItemReview(ID, reviewIndex));
                    printReviewsOptionsMenu();
                    option = UserInput.readInt("Enter your choice: ");
                    break;

                case 3:
                    ID = UserInput.readString("Introduce the desired ID: ");
                    item = storeController.getItemById(ID);
                    System.out.println(item.printAllReviews());
                    printReviewsOptionsMenu();
                    option = UserInput.readInt("Enter your choice: ");
                    break;

                case 4:
                    ID = UserInput.readString("Introduce the desired ID: ");
                    double mean = storeController.getMeanItemGrade(ID);
                    System.out.println("Mean grade: " + mean);
                    printReviewsOptionsMenu();
                    option = UserInput.readInt("Enter your choice: ");
                    break;

                case 5:
                    ID = UserInput.readString("Introduce the desired ID: ");
                    item = storeController.getItemById(ID);
                    System.out.println("Comments: ");
                    System.out.println(item.printAllComments());
                    printReviewsOptionsMenu();
                    option = UserInput.readInt("Enter your choice: ");
                    break;

                case 6:
                    System.out.println(storeController.printAllReviews());
                    printReviewsOptionsMenu();
                    option = UserInput.readInt("Enter your choice: ");
                    break;

                case 7:
                    System.out.println(storeController.printMostReviewedItems());
                    printReviewsOptionsMenu();
                    option = UserInput.readInt("Enter your choice: ");
                    break;

                case 8:
                    System.out.println(storeController.printLeastReviewedItems());
                    printReviewsOptionsMenu();
                    option = UserInput.readInt("Enter your choice: ");
                    break;

                case 9:
                    System.out.println(storeController.printBestMeanReviews());
                    printReviewsOptionsMenu();
                    option = UserInput.readInt("Enter your choice: ");
                    break;

                case 10:
                    System.out.println(storeController.printWorseMeanReviews());
                    printReviewsOptionsMenu();
                    option = UserInput.readInt("Enter your choice: ");
                    break;

                default:
                    System.out.println("Invalid menu option. Please type another option");
                    option = UserInput.readInt("Enter your choice: ");
                    break;
            }

        }while(option != 0);

}}
