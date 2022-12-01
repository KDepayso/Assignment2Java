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

    public int determineStreakScore(){
        return 0;
    }

    private int determineLongestStreak(){
        int[] ranks = getRanksOfHand();
        int streakLength = 1, maxStreakLength = 0;

        for(int i = 0; i < ranks.length - 1; i++){

            if(ranks[i] + 1 == ranks[i+1]){
                streakLength++;
            }
            else {
                streakLength = 1;
            }

            if(maxStreakLength < streakLength){
                maxStreakLength = streakLength;
            }

        }

        return maxStreakLength;
    }

    private int[] getRanksOfHand(){
        sortHand();

        int[] ranks = new int[this.getCurrentSize()];
        Card[] cards = this.toArray();

        for(int i = 0; i < ranks.length; i++){
            ranks[i] = cards[i].getRankValue();
        }

        return ranks;
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

    public Card[] getLongestStreakOfCards(){
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
