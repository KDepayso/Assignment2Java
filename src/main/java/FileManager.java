import java.io.*;


public class FileManager {

    private final File file;

    public FileManager(File File){
        file = File;
    }

    public void writeToFile(Object finalScore) {
        try(BufferedWriter myWriter = new BufferedWriter(new FileWriter(file,true))) {
            myWriter.append(finalScore.toString());
            myWriter.newLine();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }

    }

    public void clearFile(){
        try {
            BufferedWriter myWriter = new BufferedWriter(new FileWriter(file));
            myWriter.newLine();
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    //Scanner could be used but BufferedReader is faster for only reading.
    public AListArray<String> readFile(){

        AListArray<String> stringList = new AListArray<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){

            String currentLine;
            while((currentLine = reader.readLine()) != null){
                if(currentLine.trim().length() == 0) continue;
                stringList.add(currentLine);
            }
        } catch (IOException e) {
            System.out.println("High Score file could not be found");
        }

        return stringList;
    }

}