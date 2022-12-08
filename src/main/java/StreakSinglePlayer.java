public class StreakSinglePlayer extends Streak{

    String playerName;

    public StreakSinglePlayer(Deck deck, Hand hand, String name){
        super(deck,hand);
        playerName = name;

    }

    public void createNewGame(){
        super.createNewGame();
        addScoreToHighScore();
    }


    private void addScoreToHighScore(){
        HighScoreManager highScoreManager = new HighScoreManager();
        highScoreManager.addHighScore(createScore());
    }

    public void viewReplay(){
        replaySystem.showReplay();
    }


    private Score createScore(){
        return new Score(playerName,getScore(), getNumberOfCards());
    }













}
