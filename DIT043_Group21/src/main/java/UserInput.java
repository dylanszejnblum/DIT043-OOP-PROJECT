import java.util.Scanner;

public class UserInput {

    public static int readInt(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        int readInt = scanner.nextInt();
        scanner.nextLine();
        return readInt;
    }

    public static double readDouble(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        double readDouble = scanner.nextDouble();
        scanner.nextLine();
        return readDouble;
    }

    public static String readString(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String readString = scanner.nextLine();
        return readString;
    }
}