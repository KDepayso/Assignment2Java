import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class HighScoreManagerTest {

    static File highScoreFile = new File("./src/main/resources/HighScores.txt");
    static File testFile = new File("./src/test/resources/HighScoresTest.txt");

    static HighScoreManager highScoreManager = new HighScoreManager();

    @BeforeAll
    static void populateTestFile(){

        Score testScore1 = new Score("Test1",2,5);
        Score testScore2 = new Score("Test2",3,5);
        Score testScore3 = new Score("Test3",4,5);
        Score testScore4 = new Score("Test4",5,5);
        Score testScore5 = new Score("Test5",6,5);

        highScoreManager.writeScoreToFile(testScore1);
        highScoreManager.writeScoreToFile(testScore2);
        highScoreManager.writeScoreToFile(testScore3);
        highScoreManager.writeScoreToFile(testScore4);
        highScoreManager.writeScoreToFile(testScore5);

    }


    @Test
    void correctFile(){
        assertTrue(highScoreFile.exists());
    }


    @Test
    void canValidScoreBeAdded(){
        Score validScore = new Score("Test", 10, 5);
        //highScoreManager.writeScoreToFile(validScore);


    }

    @Test
    void isInvalidScoreRejected(){
        Score invalidScore = new Score("Test", 1, 5);
        //highScoreManager.writeScoreToFile(invalidScore);

    }

    @Test
    void isEvenScoreRejected(){
        Score invalidScore = new Score("Test", 2, 5);
        //highScoreManager.writeScoreToFile(invalidScore);
    }




}