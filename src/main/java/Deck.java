import java.util.Random;

public final class Deck extends Bag {

    private final Card[] deck = new Card[52];
    private int numberOfEntries;


    public Deck() {

        generateNewDeckOfCards();
    }

    public void generateNewDeckOfCards(){
        numberOfEntries = 0;

        for(Suits suits : Suits.values()){

            for(Ranks ranks : Ranks.values()){

                Card newCard = new Card(ranks,suits);
                deck[numberOfEntries] = newCard;
                numberOfEntries++;
            }
        }
    }

    public void shuffleDeck(){
        Random rand = new Random();

        for (int i = 0; i < deck.length; i++) {
            int randomIndexToSwap = rand.nextInt(deck.length);
            Card temp = deck[randomIndexToSwap];
            deck[randomIndexToSwap] = deck[i];
            deck[i] = temp;
        }
    }

    @Override
    public boolean addNewEntry(Card newEntry) {
        return super.addNewEntry(newEntry);
    }



    @Override
    public int getCurrentSize(){
        return numberOfEntries;
    }

    @Override
    public String toString(){
        String strResult = "";
        for (Card card : deck) {
            strResult += card.toString() + "\n";
        }
        return strResult;
    }


}
