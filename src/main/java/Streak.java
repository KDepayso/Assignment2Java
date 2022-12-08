public abstract class Streak {

    private final Deck streakDeck;
    private final Hand streakHand;
    private int numberOfSwaps = 0;

    ReplaySystem replaySystem = new ReplaySystem();



    protected Streak(Deck deck, Hand hand){
        streakDeck = deck;
        streakHand = hand;
    }


    protected void createNewGame(){
        dealHand();
        displayScoreAndHand();
        exchangeCardsPhase();
    }

    private void exchangeCardsPhase(){
        int choice;
        while(numberOfSwaps < streakHand.getMaximumSize()){
            System.out.println(numberOfSwaps + 1 + " of " + streakHand.getMaximumSize() + ": Choose card to exchange or 0 to exit");
            choice = GetIntInput.getChoice();

            if(choice == 0) break;

            exchangeCardCounter(choice);
            displayScoreAndHand();
        }

    }


    protected void dealHand(){
        for(int i = 0; i < streakHand.getMaximumSize(); i++){
            streakHand.addNewEntry(streakDeck.removeRandomCard());
        }
        replaySystem.addHandStateToQueue(getHandState());
    }

    protected void exchangeCardCounter(int cardIndex){
        if(numberOfSwaps < streakHand.getMaximumSize()){

            Card cardToRemoveFromHand = selectCardToExchange(cardIndex -1);
            Card cardToAddToHand = streakDeck.removeRandomCard();

            exchangeCard(cardToRemoveFromHand,cardToAddToHand);


            addToReplay(cardToRemoveFromHand,cardToAddToHand);
            numberOfSwaps++;
        }
    }

    private void exchangeCard(Card cardToRemoveFromHand, Card cardToAddToHand){
        streakDeck.remove(cardToAddToHand);
        streakHand.remove(cardToRemoveFromHand);

        streakHand.addNewEntry(cardToAddToHand);
        streakDeck.addNewEntry(cardToRemoveFromHand);
    }

    private void addToReplay(Card cardToRemoveFromHand, Card cardToAddToHand){

        RemoveFromHand removeFromHand = new RemoveFromHand(cardToRemoveFromHand);
        AddToHand addToHand = new AddToHand(cardToAddToHand);

        replaySystem.addMoveToQueue(removeFromHand);
        replaySystem.addMoveToQueue(addToHand);
        replaySystem.addHandStateToQueue(getHandState());
    }

    private Hand getHandState(){
        Hand handState = new Hand(streakHand.getMaximumSize());
        return handState.copyFromOtherHand(streakHand);
    }

    private Card selectCardToExchange(int cardIndex){
        return streakHand.toArray()[cardIndex];
    }

    protected int getScore(){
        return streakHand.getScore();
    }

    protected int getNumberOfCards(){
        return streakHand.getCurrentSize();
    }


    public void displayScoreAndHand(){
        streakHand.calculateFinalScore();
        displayHand();
        System.out.println("\nYour highest score is " + getScore());
    }

    private void displayHand(){
        System.out.println("\n" + streakHand.toStringNumbered());
    }

    protected void resetGame(){
        streakHand.clear();
        streakDeck.generateNewDeckOfCards();
    }











}
