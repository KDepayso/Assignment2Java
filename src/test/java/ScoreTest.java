import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    @Test
    void compareTo() {
        Score scoreOf5= new Score("Test", 5, 5);
        Score scoreOf10 = new Score("Test", 10, 10);
        Score anotherScoreOf10 = new Score("Test", 10, 10);

        assertEquals(-1,scoreOf5.compareTo(scoreOf10));
        assertEquals(1,scoreOf10.compareTo(scoreOf5));
        assertEquals(0,scoreOf10.compareTo(anotherScoreOf10));

    }

    @Test
    void toStringTest(){
        Score testScore = new Score("Test",10, 10);
        assertEquals("Test | 10 | 10 cards per hand",testScore.toString());
    }
}