import com.sun.org.apache.xerces.internal.xs.XSTerm;

import java.util.Scanner;

public abstract class Streak {

    private final Deck streakDeck;
    private final Hand streakHand;
    private int score;

    public Streak(Deck deck, Hand hand){
        streakDeck = deck;
        hand.sortHand();
        streakHand = hand;
    }

    public void dealHand(){

        for(int i = 0; i < streakHand.getMaximumSize(); i++){
            streakHand.addNewEntry(streakDeck.removeRandomCard());
        }
    }

    public void exchangeCards(){
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        while(count < streakHand.getMaximumSize()){
            System.out.println("Do you want to exchange a card? (y/n)");
            String input = scanner.next();
            if(yesOrNo(input)){
                streakHand.exchangeCard(streakDeck,selectCardToExchange());
                count++;
            }
            else{
                count = streakHand.getMaximumSize();
            }
        }
    }

    private Boolean yesOrNo(String input){
        boolean result = false;
        switch (input.toLowerCase()){
            case "y":
            case "yes":{
                result = true;

            }
            break;
            case "n":
            case "no":{
                result = false;
            }
            break;
            default:{
                Scanner scanner = new Scanner(System.in);
                System.out.println("Invalid input detected, please enter 'yes' or 'no'");
                yesOrNo(scanner.next());

            }
        }
        return result;
    }

    private Card selectCardToExchange(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the card you want to exchange");
        System.out.println(streakHand.toStringNumbered());
        String input = scanner.next();

        if(tryParse(input) == 0) input = scanner.next();

        int cardIndex = tryParse(input);


        return streakHand.toArray()[cardIndex -1];
    }

    private int tryParse(String text){
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number, please try again");
            return 0;
        }
    }

    public void calculateScore(){

    }











}
