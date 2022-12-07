import java.io.*;


public class HighScoreManager{


    FileManager fileManager;
    private final File highScoreFile = new File("./src/main/resources/HighScores.txt");
    AListArray<Score> currentHighScores;

    public HighScoreManager(){
        fileManager = new FileManager(highScoreFile);
        currentHighScores = stringToScoreList(fileManager.readFile());
    }

    //Only used for JUnit Testing.
    protected HighScoreManager(File testFile){
        fileManager = new FileManager(testFile);
        currentHighScores = stringToScoreList(fileManager.readFile());
        sortScoreList(currentHighScores);

    }

    public boolean isScoreAHighScore(Score newScore){
        boolean validScore = false;
        if(currentHighScores.getLength() < 5){
            validScore = true;
        }
        return validScore;
    }

    public void sortScoreList(AListArray<Score> scoreList){
        int firstPos = 1, lastPos = scoreList.getLength() - 1;
        int lastSwapPos;
        Score temp;

        while(firstPos < lastPos){
            lastSwapPos = firstPos;
            for(int j = 1; j < lastPos; j++){
                if (scoreList.getEntry(j).compareTo(scoreList.getEntry(j + 1)) > 0){
                    temp = scoreList.getEntry(j);
                    scoreList.replace(j,scoreList.getEntry(j + 1));
                    scoreList.replace(j,temp);
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


    public void displayHighScores(){
        for(int i = 1; i <= currentHighScores.getLength(); i++){
            currentHighScores.getEntry(i).display();
        }
    }






}
