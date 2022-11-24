import java.util.Random;

public final class Deck extends Bag {


    public Deck() {
        super(52);

    }


    public void generateNewDeckOfCards(){

        for(Suits suits : Suits.values()){

            for(Ranks ranks : Ranks.values()){

                Card newCard = new Card(ranks,suits);
                addNewEntry(newCard);
            }
        }
    }

    public void shuffleDeck(){
        Random rand = new Random();
        Card[] deck = super.toArray();

        for (int i = 0; i < deck.length; i++) {
            int randomIndexToSwap = rand.nextInt(this.getCurrentSize());
            Card temp = deck[randomIndexToSwap];
            deck[randomIndexToSwap] = deck[i];
            deck[i] = temp;
        }

        replaceDeck(deck);

    }
    private void replaceDeck(Card[] replacementDeck){
        this.clear();
        for(Card card: replacementDeck){
            this.addNewEntry(card);
        }
    }







}
