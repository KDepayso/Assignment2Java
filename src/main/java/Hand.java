import java.util.Random;

public class Hand extends Bag{
    public Hand(int numberOfCardsInHand) {
        super(numberOfCardsInHand);

    }

    public void sortHand(){
            int firstPos = 0, lastPos = this.getCurrentSize() -1;
            int lastSwapPos;
            Card temp;
            Card[] currentHand = this.toArray();

            while(firstPos < lastPos){
                lastSwapPos = firstPos;
                for(int j = 0; j < lastPos; j++){
                    if (currentHand[j].compareTo(currentHand[j + 1]) > 0){
                        temp = currentHand[j];
                        currentHand[j] = currentHand[j+1];
                        currentHand[j+1] = temp;
                        lastSwapPos = j;
                    }
                }
                lastPos = lastSwapPos;
            }

            replaceHand(currentHand);

    }

    private void replaceHand(Card[] replacementHand){
        this.clear();
        for(Card card: replacementHand){
            this.addNewEntry(card);
        }
    }






}
