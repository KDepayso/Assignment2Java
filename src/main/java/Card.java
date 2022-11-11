import java.util.Random;

public class Card implements Comparable<Card>{
    private final int RANK, SUIT, COLOUR;

    private static final Random GENERATOR = new Random();

    private static final String[] RANKS = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
    private static final String[] SUITS = {"Diamonds", "Hearts", "Spades", "Clubs"};

    private static final String[] COLOURS = {"Black", "Red"};

    public Card(){
        RANK = GENERATOR.nextInt(RANKS.length);
        SUIT = GENERATOR.nextInt(SUITS.length);
        COLOUR = setColour();


    }

    private int setColour(){
        if(SUIT > 1)
            return 0;
        else return 1;
    }

    public String getRank(){
        return RANKS[RANK];
    }

    public String getSuit(){
        return SUITS[SUIT];
    }

    public int getRankValue(){
        return RANK;
    }

    public String getColour(){
        return COLOURS[COLOUR];
    }


    @Override
    public String toString(){
        return getRank() + " of " + getSuit();
    }

    @Override
    public int compareTo(Card otherCard){
        if(this.getRankValue() > otherCard.getRankValue()) return 1;
        else if(this.getRankValue() < otherCard.getRankValue()) return -1;
        else return 0;
    }
}
