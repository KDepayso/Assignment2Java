import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class FileManager {

    private final File file;

    public FileManager(){
        file = new File("./src/main/resources/HighScores.txt");;
    }

    protected void writeScoreToFile(Score finalScore) {
        try {
            BufferedWriter myWriter = new BufferedWriter(new FileWriter(file,true));
            myWriter.append(finalScore.toString());
            myWriter.newLine();
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    protected void clearFile(){
        try {
            BufferedWriter myWriter = new BufferedWriter(new FileWriter(file));
            myWriter.newLine();
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private AListArray<String> fileToList(){
        AListArray<String> stringList = new AListArray<>();

        try {
            File myObj = new File(file.toURI());
            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                stringList.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("High Score file could not be found");
        }

        return stringList;
    }

    protected String[] fileToStringArray(){
        fileToList();
        String[] stringArray = Arrays.copyOf(fileToList().toArray(), fileToList().getLength(), String[].class);
        return stringArray;
    }


    protected int getNumberOfLines(){
        int lines = 0;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (reader.readLine() != null) lines++;
            reader.close();

        }
        catch (IOException e){
            System.out.println("High Score file could not be found");
        }
        return lines;

    }
}