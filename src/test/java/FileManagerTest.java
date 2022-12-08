import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AssertionsKt;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {


    static File tempFile;

    @BeforeAll
    static void createTempFile() throws IOException {
        tempFile = File.createTempFile("FileManagerTest",".txt");
        tempFile.deleteOnExit();
    }

    @AfterAll
    static void deleteOnExit(){
        tempFile.deleteOnExit();
    }






    @Test
    void writeStringToFile() throws IOException {
        String testString = "Hello World";
        FileManager fileManager = new FileManager(tempFile);
        fileManager.writeToFile(testString);

        try (Stream<String> s = Files.lines(tempFile.toPath())) {
            s.forEach(s1 -> assertEquals("Hello World",s1));
        }
    }

    @Test
    void clearFile() throws IOException {
        String testString = "Hello World";
        FileManager fileManager = new FileManager(tempFile);
        fileManager.writeToFile(testString);

        fileManager.clearFile();
        assertEquals(0,fileManager.readFile().getLength());


    }

    @Test
    void readFile() {
        String testString = "Hello World";
        FileManager fileManager = new FileManager(tempFile);


        fileManager.writeToFile(testString);

        AListArray<String> stringList = fileManager.readFile();
        assertTrue(stringList.contains(testString));

    }
}