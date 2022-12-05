
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        mainMenu();

    }

    private static void mainMenu(){
        System.out.println("\n\t\tSTREAK\t\t" +
                "\n----------------------" +
                "\n1. Single Player Game" +
                "\n2. 2-Player Game" +
                "\n3. View High Score Table" +
                "\n9. Exit" +
                "\n\nEnter Choice > ");

        singlePlayerGame();

    }

    private static void singlePlayerGame(){
        int numberOfCards;
        String name;

        System.out.print("You have selected Single Player Game, please Enter your name > ");
        name = getName();

        System.out.print("Please enter the number of cards you want per hand > ");
        numberOfCards = GetIntInput.getChoice();

        while (numberOfCards < 5 || numberOfCards > 10){
            System.out.print("Please enter a value between 5 and 10 > ");
            numberOfCards = GetIntInput.getChoice();
        }

        Hand hand = new Hand(numberOfCards);
        Deck deck = new Deck(true);

        StreakSinglePlayer streakSinglePlayer = new StreakSinglePlayer(deck,hand,name);
        streakSinglePlayer.createNewGame();

    }

    private static String getName(){
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        NameValidator validateName = new NameValidator();

        while (!validateName.isNameValid(name)) {
            System.out.println("Invalid name, please ensure name is only letters and less than 30 characters long");
            name = scanner.next();
        }

        return name;
    }

}