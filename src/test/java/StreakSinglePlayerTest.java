import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StreakSinglePlayerTest {

    static Deck deck = new Deck();
    static Hand hand = new Hand(5);

    static Card card1 = new Card(Ranks.TWO, Suits.HEARTS);
    static Card card2 = new Card(Ranks.THREE, Suits.HEARTS);
    static Card card3 = new Card(Ranks.FOUR, Suits.HEARTS);
    static Card card4 = new Card(Ranks.FIVE, Suits.HEARTS);
    static Card card5 = new Card(Ranks.SIX, Suits.HEARTS);


    @BeforeAll
    static void generateDeckAndHand(){
        deck.generateNewDeckOfCards();

    }



    @Test
    void dealHand() {
        StreakSinglePlayer streakSinglePlayer = new StreakSinglePlayer(deck,hand,"Player");
        streakSinglePlayer.dealHand();

        Card[] handArray = hand.toArray();
        for(Card card: handArray){
            assertFalse(deck.contains(card));
        }
    }

    @Test
    void exchangeCards(){
        StreakSinglePlayer streakSinglePlayer = new StreakSinglePlayer(deck,hand,"Player");
        streakSinglePlayer.dealHand();
        streakSinglePlayer.exchangeCards();


    }


}