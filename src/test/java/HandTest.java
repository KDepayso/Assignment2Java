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
    void isLengthScoreCalculated(){

        Hand tempHand = new Hand(5);


        Card card1 = new Card(Ranks.TWO, Suits.CLUBS);
        Card card2 = new Card(Ranks.THREE, Suits.HEARTS);
        Card card3 = new Card(Ranks.EIGHT, Suits.CLUBS);
        Card card4 = new Card(Ranks.FIVE, Suits.HEARTS);
        Card card5 = new Card(Ranks.SIX, Suits.HEARTS);

        tempHand.addNewEntry(card1);
        tempHand.addNewEntry(card2);
        tempHand.addNewEntry(card3);
        tempHand.addNewEntry(card4);
        tempHand.addNewEntry(card5);

        assertEquals(2,tempHand.determineStreakScore());


    }

    @Test
    void isSuitScoreCalculated(){

        generateHand();
        assertEquals(7, hand.determineStreakScore());
    }

    @Test
    void isColourScoreCalculated(){

        Hand tempHand = new Hand(5);

        Card card1 = new Card(Ranks.TWO, Suits.DIAMONDS);
        Card card2 = new Card(Ranks.THREE, Suits.HEARTS);
        Card card3 = new Card(Ranks.EIGHT, Suits.DIAMONDS);
        Card card4 = new Card(Ranks.FIVE, Suits.HEARTS);
        Card card5 = new Card(Ranks.SIX, Suits.HEARTS);

        tempHand.addNewEntry(card1);
        tempHand.addNewEntry(card2);
        tempHand.addNewEntry(card3);
        tempHand.addNewEntry(card4);
        tempHand.addNewEntry(card5);

        assertEquals(3,tempHand.determineStreakScore());
    }

    @Test
    void doesLengthOverrideSuitBonus(){

        /*
            In this case, a 2-3-4-5 steak of the same suit will result in a higher score of 6
            compared to a 2-3-4-5-6 steak of a mismatched suit result of only 5.

            An argument could be made to choose the highest possible score, regardless of if it comes from the longest
            streak, however, in this case the longest possible streak is determined first before adding any potential
            bonuses.

         */

        Hand tempHand = new Hand(5);

        Card card1 = new Card(Ranks.TWO, Suits.HEARTS);
        Card card2 = new Card(Ranks.THREE, Suits.HEARTS);
        Card card3 = new Card(Ranks.FOUR, Suits.HEARTS);
        Card card4 = new Card(Ranks.FIVE, Suits.HEARTS);
        Card card5 = new Card(Ranks.SIX, Suits.SPADES);

        tempHand.addNewEntry(card1);
        tempHand.addNewEntry(card2);
        tempHand.addNewEntry(card3);
        tempHand.addNewEntry(card4);
        tempHand.addNewEntry(card5);

        assertEquals(5,tempHand.determineStreakScore());

    }

    @Test
    void exchangeCard(){
        Deck deck = new Deck();
        Hand testHand = new Hand(1);

        deck.addNewEntry(card1);
        testHand.addNewEntry(card2);

        testHand.exchangeCard(deck,card2);

        assertTrue(testHand.contains(card1));
        assertTrue(deck.contains(card2));
        assertFalse(testHand.contains(card2));
        assertFalse(deck.contains(card1));

    }



}