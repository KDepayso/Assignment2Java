import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CardTests {

    Card tenOfDiamonds = new Card(Ranks.TEN, Suits.DIAMONDS);
    Card kingOfHearts = new Card(Ranks.KING,Suits.HEARTS);
    Card aceOfSpades = new Card(Ranks.ACE, Suits.SPADES);
    Card twoOfClubs = new Card(Ranks.TWO, Suits.CLUBS);

    @Test
    void returnCorrectRankValue(){ assertEquals(12, aceOfSpades.getRankValue());}

    @Test
    void returnCorrectSuitValue(){ assertEquals("DIAMONDS", tenOfDiamonds.getSuit());}

    @Test
    void returnCorrectRank(){ assertEquals("TEN", tenOfDiamonds.getRank());}

    @Test
    void isDiamondsRed(){
        assertEquals(Colours.RED.toString(),tenOfDiamonds.getColour());
    }

    @Test
    void isHeartsRed(){
        assertEquals(Colours.RED.toString(),kingOfHearts.getColour());
    }

    @Test
    void isSpadesBlack(){
        assertEquals(Colours.BLACK.toString(),aceOfSpades.getColour());
    }

    @Test
    void isClubsBlack(){ assertEquals(Colours.BLACK.toString(),twoOfClubs.getColour()); }

    @Test
    void doesToStringPrintCorrectly(){
        assertEquals("TEN of DIAMONDS",tenOfDiamonds.toString());
    }

    @Test
    void isTenGreaterThanTwo(){
        assertEquals(1,tenOfDiamonds.compareTo(twoOfClubs));
    }

    @Test
    void isTenLessThanKing(){
        assertEquals(-1,tenOfDiamonds.compareTo(kingOfHearts));
    }

    @Test
    void isTenEqualToTen(){
        Card tenOfSpades = new Card(Ranks.TEN, Suits.SPADES);
        assertEquals(0,tenOfDiamonds.compareTo(tenOfSpades));
    }

    @Test
    void isTenEqualToTenUsingEquals(){
        Card tenOfSpades = new Card(Ranks.TEN, Suits.SPADES);
        Card tenOfSpades2 = new Card(Ranks.TEN, Suits.SPADES);
        assertTrue(tenOfSpades.equals(tenOfSpades2));
    }





}