

public class RemoveFromHand implements DoMove{
    private final Card card;

    public RemoveFromHand(Card _card){
        card = _card;
    }


    public String toString(){
        return card + " was removed from the hand";
    }
}
