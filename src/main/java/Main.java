
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        mainMenu();

    }

    private static void mainMenu(){
        System.out.print("\n\t\tSTREAK\t\t" +
                "\n----------------------" +
                "\n1. Single Player Game" +
                "\n2. 2-Player Game" +
                "\n3. View High Score Table" +
                "\n9. Exit" +
                "\n\nEnter Choice > ");

        getUserChoice();

    }

    private static void getUserChoice(){
        int choice;
        choice = GetIntInput.getChoice();

        switch (choice){
            case 1: singlePlayerGame();
                break;
            case 2: twoPlayerGame();
                break;
            case 3: viewHighScoreTable();
                break;
            case 9: System.exit(0);
                break;
            default:
                System.out.println("\nInvalid input detected, please try again");
                break;
        }

        mainMenu();

    }

    private static void singlePlayerGame(){
        int numberOfCards;
        String name;

        System.out.print("\nYou have selected Single Player Game, please enter your name > ");
        name = getName();

        System.out.print("Please enter the number of cards you want per hand > ");
        numberOfCards = GetIntInput.getChoice();

        while (numberOfCards < 5 || numberOfCards > 10){
            System.out.print("Please enter a value between 5 and 10 > ");
            numberOfCards = GetIntInput.getChoice();
        }

        Deck deck = new Deck(true);
        Hand hand = new Hand(numberOfCards);


        StreakSinglePlayer streakSinglePlayer = new StreakSinglePlayer(deck,hand,name);
        streakSinglePlayer.createNewGame();

        System.out.println("Do you want to view a replay?");
        streakSinglePlayer.viewReplay();

    }
    private static void twoPlayerGame(){
        int numberOfCards;
        String playerOneName, playerTwoName;

        System.out.print("\nYou have selected Two Player Game, please enter the name of player one > ");
        playerOneName = getName();

        System.out.print("Please enter the name of player two > ");
        playerTwoName = getName();

        while (playerOneName.equals(playerTwoName)){
            System.out.println("Player names cannot be the same, please enter another name");
            playerTwoName = getName();
        }

        System.out.print("Please enter the number of cards you want per hand > ");
        numberOfCards = GetIntInput.getChoice();

        while (numberOfCards < 5 || numberOfCards > 10){
            System.out.print("Please enter a value between 5 and 10 > ");
            numberOfCards = GetIntInput.getChoice();
        }

        Deck deck = new Deck(true);
        Hand hand = new Hand(numberOfCards);


        StreakTwoPlayer streakTwoPlayer = new StreakTwoPlayer(deck, hand, playerOneName, playerTwoName);
        streakTwoPlayer.createFullGame();

    }
    private static void viewHighScoreTable(){
        HighScoreManager highScoreManager = new HighScoreManager();
        highScoreManager.displayHighScores();
    }

    private static String getName(){
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        NameValidator validateName = new NameValidator();

        while (!validateName.isNameValid(name)) {
            System.out.println("\nInvalid name, please ensure name is only letters and less than 30 characters long");
            name = scanner.next();
        }

        return name;
    }

}