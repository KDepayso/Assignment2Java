
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
    public String toString(){ return getRank() + " of " + getSuit(); }

    @Override
    public int compareTo(Card otherCard){
        return Integer.compare(this.getRankValue(), otherCard.getRankValue());
    }


    /*Without override, equals compares by identity. Two objects created by new will always have distinct identities
    and therefore will never be equal. Hashmap should also be overridden, but I will not be using it, so I chose not
    to.

     */
    @Override
    public boolean equals(Object card){
        if(card == null) return false;

        if(card.getClass() != this.getClass()) return false;

        Card otherCard = (Card) card;

        if(this.rank != otherCard.rank) return false;

        if(this.suit != otherCard.suit) return false;

        return true;

    }



}
