public class StreakTwoPlayer extends Streak{
    String firstPlayerName, secondPlayerName;
    Score playerOneFinalScore, playerTwoFinalScore;


    public StreakTwoPlayer(Deck deck, Hand hand, String FirstPlayerName, String SecondPlayerName){
        super(deck,hand);
        firstPlayerName = FirstPlayerName;
        secondPlayerName = SecondPlayerName;

    }

    public void createFullGame(){
        playerOneFinalScore = generatePlayerGame(firstPlayerName);
        System.out.println(resultsOfGame(playerOneFinalScore));

        playerTwoFinalScore = generatePlayerGame(secondPlayerName);
        System.out.println(resultsOfGame(playerTwoFinalScore));

        System.out.println(determineWinner());

    }

    private Score generatePlayerGame(String playerName){
        int finalScore = 0;

        for(int i = 0; i < 3 ; i++){
            int currentScore = 0;
            super.createNewGame();

            finalScore += getScore();
            currentScore += getScore();

            addScoreToHighScores(playerName,currentScore);

            System.out.println("\n" + playerName + " has a current total score of " + finalScore);
            super.resetGame();
        }

        return createScore(playerName, finalScore);
    }

    private String determineWinner(){

        String winningMessage = " wins with a final score of " + getNumberOfCards();

        if(playerOneFinalScore.compareTo(playerTwoFinalScore) > 0){
            return firstPlayerName + winningMessage;
        }
        else if(playerOneFinalScore.compareTo(playerTwoFinalScore) < 0){
            return secondPlayerName + winningMessage;
        }
        else return  "Game is a draw";

    }

    private String resultsOfGame(Score playerScore){
        return "\n" + playerScore.getName() + " has finished playing with a final score of " + playerScore.getScore();
    }

    private void addScoreToHighScores(String playerName, int score){
        HighScoreManager highScoreManager = new HighScoreManager();
        highScoreManager.addHighScore(createScore(playerName, score));
    }

    private Score createScore(String playerName, int finalScore){
        return new Score(playerName,finalScore, getNumberOfCards());
    }



}
