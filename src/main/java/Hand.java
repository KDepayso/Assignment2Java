public class Hand extends Bag{

    int maxCards;
    public Hand(int numberOfCardsInHand) {
        super(numberOfCardsInHand);
        maxCards = numberOfCardsInHand;

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


    /*
        Card will be taken from deck before card from hand is removed
        This will prevent the user from potentially getting the same card that they exchanged.
     */
    public void exchangeCard(Deck currentDeck,Card cardToExchange){

        remove(cardToExchange);
        addNewEntry(currentDeck.removeRandomCard());
        currentDeck.addNewEntry(cardToExchange);
    }

    public int determineStreakScore(){
        int score;
        Card[] bestStreakOfCards = getLongestStreakOfCards();
        score = bestStreakOfCards.length;
        if(bonusPointSuit()){
            score++;
        }
        if(bonusPointColour()){
            score++;
        }

        return score;

    }

    private boolean bonusPointColour(){
        Card[] cards = getLongestStreakOfCards();
        Colours streakColour = Colours.valueOf(cards[0].getColour());
        for(Card card : cards){
            if(Colours.valueOf(card.getColour()) != streakColour){
                return false;
            }
        }

        return true;
    }

    private boolean bonusPointSuit(){
        Card[] cards = getLongestStreakOfCards();
        Suits currentSuit = Suits.valueOf(cards[0].getSuit());
        for(Card card : cards){
            if(Suits.valueOf(card.getSuit()) != currentSuit){
                return false;
            }
        }

        return true;
    }

    /*
    Add cards to a temp array and then check next card in hand to see if it's in sequence.
    If it is, that card will also be added to the temp array.
    If not, the temp array will be cleared as it is no longer in sequence.
    After each card is added to the temp hand, the length of the temp hand is compared to the current best hand and
    if the best hand is smaller than the temp hand, the temp hand will be copied to the best hand.
    A separate copy method had to be created, as using 'bestHand = tempHand' would equate their references and not copy
    the values.

    A downside of this method is that it will attempt to add duplicate cards to the hand, however there is validation
    in place to prevent this from happening. The only downside is that it is inefficient.
     */
    private Card[] getLongestStreakOfCards(){
        this.sortHand();
        Card[] handArray = this.toArray();

        Hand bestHand = new Hand(getMaximumSize());
        Hand tempHand = new Hand(getMaximumSize());

        for(int i = 0; i < getCurrentSize() - 1; i ++){

            if(handArray[i].getRankValue() + 1 == handArray[i + 1].getRankValue()){
                tempHand.addNewEntry(handArray[i]);
                tempHand.addNewEntry(handArray[i + 1]);
            }
            else{
                tempHand.clear();
            }
            if(bestHand.getCurrentSize() < tempHand.getCurrentSize()){
                bestHand = copyFromOtherHand(tempHand);
            }

        }

        return bestHand.toArray();

    }

    private Hand copyFromOtherHand(Hand otherHand){
        Card[] otherHandArray = otherHand.toArray();

        Hand newHand = new Hand(otherHandArray.length);
        for(Card card : otherHandArray){
            newHand.addNewEntry(card);
        }

        return newHand;
    }








}
