import java.util.Scanner;

public class Input {

    public static int readInt(Scanner sc, String prompt) {
        System.out.println(prompt);
        while(!sc.hasNextInt()) {
            System.out.println("Enter a number: ");
            sc.next();
        }
        return sc.nextInt();
    }

    public static char readChar(Scanner sc, String prompt) {
        System.out.println(prompt);
        while(!sc.hasNext()) {
            System.out.println("Enter a char: ");
            sc.next();
        }
        return sc.next().charAt(0);
    }

    public static String readString(Scanner sc, String prompt) {
        System.out.println(prompt);
        while (!sc.hasNextLine()) {
            System.out.println("Enter a string: ");
            sc.nextLine();
        }
        return sc.nextLine();
    }
}
