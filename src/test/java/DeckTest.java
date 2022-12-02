import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

     Deck deck = new Deck();

    Card testCard = new Card(Ranks.ACE,Suits.HEARTS);



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
    void getMaxSize(){
        assertEquals(52,deck.getMaximumSize());
    }

    @Test
    void returnNumberEntries(){

        deck.generateNewDeckOfCards();
        assertEquals(52,deck.getCurrentSize());

        deck.remove(testCard);
        assertEquals(51,deck.getCurrentSize());

        Deck newDeck = new Deck();
        assertEquals(0,newDeck.getCurrentSize());

    }

    @Test
    void doesDeckContainCard(){
        deck.generateNewDeckOfCards();
        assertTrue(deck.contains(testCard));

    }

    @Test
    void addNewCardToDeck(){
        Deck emptyDeck = new Deck();
        emptyDeck.addNewEntry(testCard);
        assertTrue(emptyDeck.contains(testCard));

    }


    @Test
    void ifBagIsFullCantAddCards(){
        deck.generateNewDeckOfCards();
        assertFalse(deck.addNewEntry(testCard));

    }

    @Test
    void canDuplicateCardsBeAdded(){
        deck.generateNewDeckOfCards();
        assertFalse(deck.addNewEntry(testCard));

    }

    @Test
    void canCardsBeRemoved(){
        deck.generateNewDeckOfCards();
        deck.remove(testCard);
        assertFalse(deck.contains(testCard));
    }

    @Test
    void canARemovedCardBeReAdded(){
        deck.generateNewDeckOfCards();
        deck.remove(testCard);
        assertFalse(deck.contains(testCard));
        deck.addNewEntry(testCard);
        assertTrue(deck.contains(testCard));
    }

    @Test
    void canDeckBeCleared(){
        deck.generateNewDeckOfCards();
        assertEquals(52,deck.getCurrentSize());
        deck.clear();
        assertEquals(0,deck.getCurrentSize());

    }

    @Test
    void toArrayMethod(){
        deck.generateNewDeckOfCards();
        assertArrayEquals(generateArrayOfCards(),deck.toArray());
    }

    private Card[] generateArrayOfCards(){

        Card[] cardArray = new Card[52];
        int count = 0;

        for(Suits suits : Suits.values()){

            for(Ranks ranks : Ranks.values()){

                Card newCard = new Card(ranks,suits);
                cardArray[count] = newCard;
                count++;
            }
        }

        return cardArray;
    }

    @Test
    void retrievingCardFromDeck(){
        deck.generateNewDeckOfCards();
        Card retrievedCard = deck.remove(testCard);
        assertEquals(retrievedCard,testCard);
    }

    @Test
    void retrievingCardRemovesCardFromDeck(){
        deck.generateNewDeckOfCards();
        deck.remove(testCard);
        assertFalse(deck.contains(testCard));
    }

    @Test
    void removeRandomCardFromDeck(){
        deck.generateNewDeckOfCards();
        Card randomCard = deck.removeRandomCard();
        assertFalse(deck.contains(randomCard));
    }








}