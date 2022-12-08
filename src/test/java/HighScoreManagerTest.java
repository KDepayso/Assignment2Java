
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


import java.io.*;


class HighScoreManagerTest {

    static File tempFile;

    static Score testScore1 = new Score("Test1",3,5);
    static Score testScore2 = new Score("Test2",2,5);
    static Score testScore3 = new Score("Test3",6,5);
    static Score testScore4 = new Score("Test4",4,5);
    static Score testScore5 = new Score("Test5",6,5);
    @BeforeAll
    static void createTempFile() throws IOException{
        tempFile = File.createTempFile("HighScoresTest",".txt");
        tempFile.deleteOnExit();
    }


    @BeforeAll
    static void populateTestFile(){

        FileManager tempFileManager = new FileManager(tempFile);

        tempFileManager.writeToFile(testScore1);
        tempFileManager.writeToFile(testScore2);
        tempFileManager.writeToFile(testScore3);
        tempFileManager.writeToFile(testScore4);
        tempFileManager.writeToFile(testScore5);


    }



    @Test
    void createHighScoreManager(){
        HighScoreManager testManager = new HighScoreManager(tempFile);

    }

    @Test
    void displayHighScores(){
        PrintStream standardOut = System.out;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));


        String expected =
        "Test1 | 3 | 5 cards per hand" +
        "\r\nTest2 | 2 | 5 cards per hand" +
        "\r\nTest3 | 6 | 5 cards per hand" +
        "\r\nTest4 | 4 | 5 cards per hand" +
        "\r\nTest5 | 6 | 5 cards per hand\r\n";

        HighScoreManager highScoreManager = new HighScoreManager(tempFile);
        highScoreManager.displayHighScores();

        assertEquals(expected,outputStreamCaptor.toString());


    }

    @Test
    void isValidScoreTrue(){
        HighScoreManager highScoreManager = new HighScoreManager(tempFile);

        Score invalidScore = new Score("Test", 7, 5);
        assertTrue(highScoreManager.addHighScore(invalidScore));
    }

    @Test
    void isValidScoreFalseWhenLess(){
        HighScoreManager highScoreManager = new HighScoreManager(tempFile);

        Score invalidScore = new Score("Test", 1, 5);
        assertFalse(highScoreManager.addHighScore(invalidScore));

    }

    @Test
    void isValidScoreFalseWhenEqual(){
        HighScoreManager highScoreManager = new HighScoreManager(tempFile);

        Score invalidScore = new Score("Test", 2, 5);
        assertFalse(highScoreManager.addHighScore(invalidScore));

    }




}