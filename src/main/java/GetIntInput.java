import java.util.Scanner;

public class GetIntInput {
    static int getChoice() {
        Scanner scanner = new Scanner(System.in);
        Integer choice = tryParseInt(scanner.next());

        if (choice == null) choice = getChoice();

        return choice;
    }

    static Integer tryParseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            System.out.println("Invalid input detected, please try again");
            return null;
        }
    }
}