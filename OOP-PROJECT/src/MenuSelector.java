import java.util.Scanner;

public class MenuSelector {
    public static void main(String[]args ){
    	int choice = -1;
    	// Base line menu for the rest of tasks.
    	// Open scanner 
    	Scanner scanner = new Scanner(System.in);

    	printMainMenu();
    	
    	choice = scanner.nextInt();
    	MainMenuOptions(choice);

		printReviewsOptionsMenu();
		option = scanner.nextInt();
		ReviewsOptionsMenu(option);
    	
    	scanner.close();
    }
    
    public static void printMainMenu() {
    	System.out.println("Main Menu: Please choose among the options below.\n" 
    + "0. Close system.\n" + "1. Open Item options. \n" + "2. Open Review options. \n" + "3. Open Transaction History options.\n" + 
    		" \n" + "\n" + 
    				"Type an option number:\n" 
    				);
    }
    
    public static void printItemOptionsMenu() {
    	System.out.println("Item options menu:\n" + 
    			"0. Return to Main Menu.\n" + 
    			"1. Create an Item.\n" + 
    			"2. Remove an Item.\n" + 
    			"3. Print all registered Items.\n" + 
    			"4. Buy an Item.\n" + 
    			"5. Update an item’s name.\n" + 
    			"6. Update an item’s price.\n" + 
    			"\n" + 
    			"Type an option number:\n" + 
    			""
    				);
    }

	public static void printReviewsOptionsMenu(){
		System.out.println("Reviews options menu:\n" +
				"0. Return to Main Menu.\n" +
				"1. Create a review for an Item.\n" +
				"2. Print a specific review of an Item.\n"+
				"3. Print all reviews of an Item.\n"+
				"4. Print mean grade of an Item\n"+
				"5. Print all comments of an Item.\n"+
				"6. Print all registered reviews.\n"+
				"7. Print item(s) with most reviews.\n"+
				"8. Print item(s) with least reviews.\n"+
				"9. Print item(s) with best mean review grade.\n"+
				"10. Print item(s) with worst mean review grade.\n"+
				"\n Type an option number:");
	}
    
    public static void MainMenuOptions(int option) {
    	switch(option) {
    	case 1:
    		printItemOptionsMenu();
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
    	
    	}
    }

	public static void ReviewsOptionsMenu(int option) {
		switch(option) {
			case 1:
				printItemOptionsMenu();
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
				System.out.println("You choose the eigth option");
				break;
			case 9:
				System.out.println("You choose the nineth option");
				break;
			case 10:
				System.out.println("You choose the tenth option");
				break;

		}
	}
}
