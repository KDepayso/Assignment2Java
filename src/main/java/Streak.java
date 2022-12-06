public abstract class Streak {

    private final Deck streakDeck;
    private final Hand streakHand;
    private int numberOfSwaps = 0;

    public Streak(Deck deck, Hand hand){
        streakDeck = deck;
        hand.sortHand();
        streakHand = hand;
    }

    public void createNewGame(){
        dealHand();
        displayScoreAndHand();
        exchangeCardsPhase();
    }

    public void exchangeCardsPhase(){
        int choice;
        while(numberOfSwaps < streakHand.getMaximumSize()){
            System.out.println(numberOfSwaps + 1 + " of " + streakHand.getMaximumSize() + ": Choose card to exchange or 0 to exit");
            choice = GetIntInput.getChoice();

            if(choice == 0) break;

            exchangeCard(choice);
            displayScoreAndHand();
        }

    }


    public void dealHand(){
        for(int i = 0; i < streakHand.getMaximumSize(); i++){
            streakHand.addNewEntry(streakDeck.removeRandomCard());
        }
    }

    public void exchangeCard(int cardIndex){
        if(numberOfSwaps < streakHand.getMaximumSize()){
            streakHand.exchangeCard(streakDeck,selectCardToExchange(cardIndex - 1));
            numberOfSwaps++;
        }

    }



    private Card selectCardToExchange(int cardIndex){
        return streakHand.toArray()[cardIndex];
    }


    public void displayScoreAndHand(){
        streakHand.calculateFinalScore();
        displayHand();
        System.out.println("\nYour highest score is " + streakHand.getScore());
    }

    private void displayHand(){
        System.out.println("\n" + streakHand.toStringNumbered());
    }











}
