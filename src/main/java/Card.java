import java.util.Random;

public class Card implements Comparable<Card>{

    private final Suits suit;
    private final Ranks rank;

    private final Colours colour;


    public Card(Ranks rank, Suits suit){
        this.suit = suit;
        this.rank = rank;
        this.colour = setColour(suit);

    }


    private Colours setColour(Suits suit){
        if(suit == Suits.DIAMONDS || suit == Suits.HEARTS)
            return Colours.RED;
        else return Colours.BLACK;
    }


    public String getRank(){
        return this.rank.toString();
    }

    public String getSuit(){
        return this.suit.toString();
    }

    public int getRankValue(){
        return this.rank.ordinal();
    }

    public String getColour(){
        return this.colour.toString();
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
