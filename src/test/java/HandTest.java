import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    static Hand hand = new Hand(5);
    static Card card1 = new Card(Ranks.TWO, Suits.HEARTS);
    static Card card2 = new Card(Ranks.THREE, Suits.HEARTS);
    static Card card3 = new Card(Ranks.FOUR, Suits.HEARTS);
    static Card card4 = new Card(Ranks.FIVE, Suits.HEARTS);
    static Card card5 = new Card(Ranks.SIX, Suits.HEARTS);


    void generateHand(){
        hand.addNewEntry(card3);
        hand.addNewEntry(card1);
        hand.addNewEntry(card5);
        hand.addNewEntry(card4);
        hand.addNewEntry(card2);
    }

    @Test
    void generateDifferentHandSizes(){
        Hand hand = new Hand(5);
        assertEquals(5,hand.getMaximumSize());

        Hand hand2 = new Hand(10);
        assertEquals(10,hand2.getMaximumSize());
    }

    @Test
    void isHandSorted(){
        generateHand();
        hand.sortHand();

        assertArrayEquals(new Card[]{card1,card2,card3,card4,card5},hand.toArray());


    }

    @Test
    void returnMaxStreakLength(){
        generateHand();
        assertEquals(5, hand.getLongestStreakOfCards().length);

        Card card1 = new Card(Ranks.TWO, Suits.HEARTS);
        Card card2 = new Card(Ranks.FOUR, Suits.HEARTS);
        Card card3 = new Card(Ranks.SIX, Suits.HEARTS);
        Card card4 = new Card(Ranks.ACE, Suits.HEARTS);
        Card card5 = new Card(Ranks.QUEEN, Suits.HEARTS);

        hand.clear();

        hand.addNewEntry(card1);
        hand.addNewEntry(card2);
        hand.addNewEntry(card3);
        hand.addNewEntry(card4);
        hand.addNewEntry(card5);

        assertEquals(0, hand.getLongestStreakOfCards().length);




    }


}