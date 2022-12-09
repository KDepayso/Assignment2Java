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
        hand.addNewEntry(card1);
        hand.addNewEntry(card2);
        hand.addNewEntry(card3);
        hand.addNewEntry(card4);
        hand.addNewEntry(card5);
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

        tempHand.calculateFinalScore();

        assertEquals(2,tempHand.getScore());


    }

    @Test
    void isSuitScoreCalculated(){

        generateHand();
        hand.calculateFinalScore();
        assertEquals(7, hand.getScore());
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

        tempHand.calculateFinalScore();

        assertEquals(3,tempHand.getScore());
    }

    @Test
    void doesNoStreakReturnZero(){
        Hand tempHand = new Hand(5);

        Card card1 = new Card(Ranks.TWO, Suits.DIAMONDS);
        Card card2 = new Card(Ranks.FOUR, Suits.HEARTS);
        Card card3 = new Card(Ranks.SEVEN, Suits.DIAMONDS);
        Card card4 = new Card(Ranks.TEN, Suits.HEARTS);
        Card card5 = new Card(Ranks.QUEEN, Suits.HEARTS);

        tempHand.addNewEntry(card1);
        tempHand.addNewEntry(card2);
        tempHand.addNewEntry(card3);
        tempHand.addNewEntry(card4);
        tempHand.addNewEntry(card5);

        tempHand.calculateFinalScore();

        assertEquals(0,tempHand.getScore());
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

        tempHand.calculateFinalScore();

        assertEquals(5,tempHand.getScore());

    }

    @Test
    void canCardBeCopiedToAnotherCard(){
        Hand tempHand = new Hand(5);
        tempHand = tempHand.copyFromOtherHand(hand);

        assertEquals(tempHand.toStringNumbered(),hand.toStringNumbered());

    }

    @Test
    void toStringNumbered(){

        generateHand();

        String expected = "1. TWO of HEARTS" +
                "\n2. THREE of HEARTS" +
                "\n3. FOUR of HEARTS" +
                "\n4. FIVE of HEARTS" +
                "\n5. SIX of HEARTS\n";

        assertEquals(expected,hand.toStringNumbered());

    }




}