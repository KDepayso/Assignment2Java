import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    Deck deck = new Deck();



    @Test
    void isNewDeckGenerated() {
        deck.generateNewDeckOfCards();
        assertEquals("TWO of DIAMONDS\n" + "THREE of DIAMONDS\n" + "FOUR of DIAMONDS\n" + "FIVE of DIAMONDS\n" +
                "SIX of DIAMONDS\n" + "SEVEN of DIAMONDS\n" + "EIGHT of DIAMONDS\n" + "NINE of DIAMONDS\n" +
                "TEN of DIAMONDS\n" + "JACK of DIAMONDS\n" + "QUEEN of DIAMONDS\n" + "KING of DIAMONDS\n" +
                "ACE of DIAMONDS\n" + "TWO of HEARTS\n" + "THREE of HEARTS\n" + "FOUR of HEARTS\n" +
                "FIVE of HEARTS\n" + "SIX of HEARTS\n" + "SEVEN of HEARTS\n" + "EIGHT of HEARTS\n" +
                "NINE of HEARTS\n" + "TEN of HEARTS\n" + "JACK of HEARTS\n" + "QUEEN of HEARTS\n" +
                "KING of HEARTS\n" + "ACE of HEARTS\n" + "TWO of SPADES\n" + "THREE of SPADES\n" +
                "FOUR of SPADES\n" + "FIVE of SPADES\n" + "SIX of SPADES\n" + "SEVEN of SPADES\n" +
                "EIGHT of SPADES\n" + "NINE of SPADES\n" + "TEN of SPADES\n" + "JACK of SPADES\n" +
                "QUEEN of SPADES\n" + "KING of SPADES\n" + "ACE of SPADES\n" + "TWO of CLUBS\n" +
                "THREE of CLUBS\n" + "FOUR of CLUBS\n" + "FIVE of CLUBS\n" + "SIX of CLUBS\n" +
                "SEVEN of CLUBS\n" + "EIGHT of CLUBS\n" + "NINE of CLUBS\n" + "TEN of CLUBS\n" +
                "JACK of CLUBS\n" + "QUEEN of CLUBS\n" + "KING of CLUBS\n" + "ACE of CLUBS\n", deck.toString());
    }

    @Test
    void isDeckShuffled(){
        deck.generateNewDeckOfCards();
        deck.shuffleDeck();
        assertNotEquals("TWO of DIAMONDS\n" + "THREE of DIAMONDS\n" + "FOUR of DIAMONDS\n" + "FIVE of DIAMONDS\n" +
                "SIX of DIAMONDS\n" + "SEVEN of DIAMONDS\n" + "EIGHT of DIAMONDS\n" + "NINE of DIAMONDS\n" +
                "TEN of DIAMONDS\n" + "JACK of DIAMONDS\n" + "QUEEN of DIAMONDS\n" + "KING of DIAMONDS\n" +
                "ACE of DIAMONDS\n" + "TWO of HEARTS\n" + "THREE of HEARTS\n" + "FOUR of HEARTS\n" +
                "FIVE of HEARTS\n" + "SIX of HEARTS\n" + "SEVEN of HEARTS\n" + "EIGHT of HEARTS\n" +
                "NINE of HEARTS\n" + "TEN of HEARTS\n" + "JACK of HEARTS\n" + "QUEEN of HEARTS\n" +
                "KING of HEARTS\n" + "ACE of HEARTS\n" + "TWO of SPADES\n" + "THREE of SPADES\n" +
                "FOUR of SPADES\n" + "FIVE of SPADES\n" + "SIX of SPADES\n" + "SEVEN of SPADES\n" +
                "EIGHT of SPADES\n" + "NINE of SPADES\n" + "TEN of SPADES\n" + "JACK of SPADES\n" +
                "QUEEN of SPADES\n" + "KING of SPADES\n" + "ACE of SPADES\n" + "TWO of CLUBS\n" +
                "THREE of CLUBS\n" + "FOUR of CLUBS\n" + "FIVE of CLUBS\n" + "SIX of CLUBS\n" +
                "SEVEN of CLUBS\n" + "EIGHT of CLUBS\n" + "NINE of CLUBS\n" + "TEN of CLUBS\n" +
                "JACK of CLUBS\n" + "QUEEN of CLUBS\n" + "KING of CLUBS\n" + "ACE of CLUBS\n", deck.toString());
    }

    @Test
    void returnNumberEntries(){
        deck.generateNewDeckOfCards();
        assertEquals(52,deck.getCurrentSize());
    }

    @Test
    void addNewCardToDeck(){
        Card testCard = new Card(Ranks.ACE,Suits.HEARTS);
        deck.addNewEntry(testCard);
        assertEquals("ACE of HEARTS", deck.toString());

    }


}