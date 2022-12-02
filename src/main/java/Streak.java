
public abstract class Streak {

    private final Deck streakDeck;
    private final Hand streakHand;
    private int score;

    public Streak(Deck deck, Hand hand){
        streakDeck = deck;
        streakHand = hand;
    }

    public void dealHand(){

        for(int i = 0; i < streakHand.getMaximumSize(); i++){
            streakHand.addNewEntry(streakDeck.removeRandomCard());
        }
    }

    public void exchangeCards(){
        int count = 0;
        while(count > streakHand.getMaximumSize()){

        }
    }

    public void calculateScore(){

    }











}
