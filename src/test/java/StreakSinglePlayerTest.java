import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StreakSinglePlayerTest {

    static Deck deck = new Deck();
    static Hand hand = new Hand(5);

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


}