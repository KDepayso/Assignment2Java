public class AddToHand implements DoMove {
    private final Card card;

    public AddToHand(Card _card){
        card = _card;
    }

    public String toString(){
        return card + " was added to the hand";
    }

    public Card getCard(){
        return card;
    }
}
