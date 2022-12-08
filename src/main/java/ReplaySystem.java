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

    public void showReplay(){
        System.out.println("Initial hand");


        while(!moves.isEmpty()){
            System.out.println(handStates.dequeue().toStringNumbered());
            System.out.println(moves.dequeue().toString());
            System.out.println(moves.dequeue().toString());

        }
    }

}
