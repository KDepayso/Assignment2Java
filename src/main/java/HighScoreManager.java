import java.io.*;


public class HighScoreManager{


    FileManager fileManager;
    AListArray<Score> currentHighScores;

    public HighScoreManager(){
        File highScoreFile = new File("./src/main/resources/HighScores.txt");
        fileManager = new FileManager(highScoreFile);
        currentHighScores = stringToScoreList(fileManager.readFile());
        sortScoreList(currentHighScores);
    }

    //Only used for JUnit Testing.
    protected HighScoreManager(File testFile){
        fileManager = new FileManager(testFile);
        currentHighScores = stringToScoreList(fileManager.readFile());
        sortScoreList(currentHighScores);

    }

    public boolean addHighScore(Score newScore){
        if(!isScoreAHighScore(newScore)) return false;
        currentHighScores.replace(5,newScore);
        fileManager.writeToFile(newScore);
        updateHighScoreFile();
        return true;
    }

    private boolean isScoreAHighScore(Score newScore){
        boolean validScore = false;
        if(currentHighScores.getLength() < 5){
            validScore = true;
        }
        if(currentHighScores.getEntry(1).compareTo(newScore) < 0){
            validScore = true;
        }
        return validScore;
    }

    private void sortScoreList(AListArray<Score> scoreList){
        int firstPos = 1, lastPos = scoreList.getLength() - 1;
        int lastSwapPos;
        Score temp;

        while(firstPos < lastPos){
            lastSwapPos = firstPos;
            for(int j = 1; j <= lastPos; j++){
                if (scoreList.getEntry(j).compareTo(scoreList.getEntry(j + 1)) > 0){
                    temp = scoreList.getEntry(j);
                    scoreList.replace(j,scoreList.getEntry(j + 1));
                    scoreList.replace(j + 1,temp);
                    lastSwapPos = j;
                }
            }
            lastPos = lastSwapPos;
        }
    }

    private AListArray<Score> stringToScoreList(AListArray<String> stringList){
        AListArray<Score> scoreList = new AListArray<>();
        for(int i = 1; i <= stringList.getLength(); i++){
            scoreList.add(convertStringToScore(stringList.getEntry(i)));
        }
        return scoreList;
    }

    private String[] splitScoreString(String fullScore){
        //Regex is written as " | "
        return fullScore.split("\\s\\|\\s");
    }

    private Score convertStringToScore(String fullScore){
        String[] ScoreString = splitScoreString(fullScore);
        return new Score(ScoreString[0],Integer.parseInt(ScoreString[1]),Integer.parseInt(ScoreString[2]));
    }

    private void updateHighScoreFile(){
        fileManager.clearFile();
        sortScoreList(currentHighScores);
        for(int i = 1; i <= currentHighScores.getLength() ; i++){
            fileManager.writeToFile(currentHighScores.getEntry(i));
        }

    }

    public void displayHighScores(){
        for(int i = 1; i <= currentHighScores.getLength(); i++){
            currentHighScores.getEntry(i).display();
        }
    }






}
