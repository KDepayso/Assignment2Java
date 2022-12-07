import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.Extensions;
import org.junit.jupiter.api.io.TempDir;

import static org.junit.jupiter.api.Assertions.*;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

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




}