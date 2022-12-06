import java.io.*;
import java.util.Arrays;

public class HighScoreManager extends FileManager {


    FileManager fileManager;
    AListArray<Score> currentHighScores;

    private final File highScoreFile = new File("./src/main/resources/HighScores.txt");

    public HighScoreManager(){
        super();
        currentHighScores = fileToScoreList();
    }



    @Override
    public void writeScoreToFile(Score newScore){
        if(getNumberOfLines() < 5){
            super.writeScoreToFile(newScore);
        }
        else if(isScoreAHighScore(newScore)){
            clearFile();
            currentHighScores.toArray()[0] = newScore;
            writeAllHighScoresToFile();
        }
    }

    private void writeAllHighScoresToFile(){
        for(Score score: currentHighScores.toArray()){
            writeScoreToFile(score);
        }
    }

    private boolean isScoreAHighScore(Score newScore){
        Score[] currentScores = sortScores(fileToScoreList().toArray());
        return newScore.compareTo(currentScores[0]) > 0;
    }

    private Score[] sortScores(Score[] scoreArray){

        int firstPos = 0, lastPos =  scoreArray.length -1;
        int lastSwapPos;
        Score temp;

        while(firstPos < lastPos){
            lastSwapPos = firstPos;
            for(int j = 0; j < lastPos; j++){
                if (scoreArray[j].compareTo(scoreArray[j + 1]) > 0){
                    temp = scoreArray[j];
                    scoreArray[j] = scoreArray[j+1];
                    scoreArray[j+1] = temp;
                    lastSwapPos = j;
                }
            }
            lastPos = lastSwapPos;
        }

        return scoreArray;
    }

    private AListArray<Score> fileToScoreList(){
        String[] scoreStringArray = fileToStringArray();

        AListArray<Score> scoreList = new AListArray<>();
        for (String score : scoreStringArray) {
            scoreList.add(convertStringToScore(score));
        }
        return scoreList;
    }

    private Score[] scoreListToScoreArray(AListArray<Score> scoreList){
        return Arrays.copyOf(scoreList.toArray(), scoreList.getLength(), Score[].class);
    }
    private String[] splitScoreString(String fullScore){

        //Regex is written as " | "
        return fullScore.split("\\s\\|\\s");
    }

    private Score convertStringToScore(String fullScore){
        String[] ScoreString = splitScoreString(fullScore);
        return new Score(ScoreString[0],Integer.parseInt(ScoreString[1]),Integer.parseInt(ScoreString[2]));
    }


    public void displayHighScores(){
        for(Score score: currentHighScores.toArray()){
            System.out.println(score.display());
        }
    }






}
