
// this is a first iteration  , the idea for the future is that the number of options 
// is calculated in accordance of an array of strings and stiched toghether on the constructor
public abstract class Menu {
	protected static String text;
	protected static int NumbersOfOption;
	
		
	public Menu(String text , int TextOptions) {
		if(TextOptions < 1) {
			throw new IllegalArgumentException("Text Options must be greater than 1");

		}
		Menu.text = text;
		Menu.NumbersOfOption = TextOptions;
	}
	
	
    public static void printItemOptionsMenu() {
    	System.out.println(text);
    }
	

}
