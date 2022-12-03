import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Hand hand = new Hand(5);
//        Card card1 = new Card(Ranks.TWO, Suits.HEARTS);
//        Card card2 = new Card(Ranks.THREE, Suits.HEARTS);
//        Card card3 = new Card(Ranks.FOUR, Suits.HEARTS);
//        Card card4 = new Card(Ranks.FIVE, Suits.HEARTS);
//        Card card5 = new Card(Ranks.SIX, Suits.HEARTS);
//
//        hand.addNewEntry(card3);
//        hand.addNewEntry(card1);
//        hand.addNewEntry(card5);
//        hand.addNewEntry(card4);
//        hand.addNewEntry(card2);

        System.out.println(hand);

        hand.sortHand();

        System.out.println(hand.toStringNumbered());

        Deck deck = new Deck();
        deck.generateNewDeckOfCards();

        StreakSinglePlayer streakSinglePlayer = new StreakSinglePlayer(deck,hand,"Player");
        streakSinglePlayer.dealHand();
        streakSinglePlayer.exchangeCards();






    }
}