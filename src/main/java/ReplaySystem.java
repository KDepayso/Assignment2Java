
public class ReplaySystem {

    MyQueue<DoMove> moves = new MyQueue<>();
    MyQueue<Hand> handStates = new MyQueue<>();


    public void addMoveToQueue(DoMove move){
        moves.enqueue(move);
    }

    public void addHandStateToQueue(Hand handState){
        handState.sortHand();
        handStates.enqueue(handState);
    }

    public void showFullReplay(){
        System.out.println("Initial hand\n\n");

        while(!moves.isEmpty()){
            showReplayStep();
        }

        System.out.println("Final hand state");
        System.out.println(handStates.dequeue().toStringNumbered());
        pressEnterToContinue();

    }

    private void showReplayStep() {

        if(!moves.isEmpty()) {
            System.out.println(handStates.dequeue().toStringNumbered());
            System.out.println(printExchange());
            pressEnterToContinue();
        }
    }

    private String printExchange(){
        Card cardToRemove = moves.dequeue().getCard();
        Card cardToAdd = moves.dequeue().getCard();

        return cardToRemove + " was exchanged with " + cardToAdd;
    }
    private void pressEnterToContinue()
    {
        System.out.println("\nPress Enter key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }


}
