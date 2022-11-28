public class MyQueue<T> {

    private MyNode<T> front, rear;
    private int size;

    public MyQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(T newEntry){
        MyNode<T> newNode = new MyNode<T>(newEntry);
        if(front == null){
            front = newNode;
        }
        else {
            rear.setNextNode(newNode);
        }
        rear = newNode;

        size++;
    }

    public T dequeue(){
        if(front == null) return null;

        T valueToReturn = front.getData();
        front = front.getNextNode();
        if(front == null) rear = null;
        size--;

        return valueToReturn;
    }

    public T getFront(){
        if(front == null) return null;
        else return front.getData();
    }

    public boolean isEmpty(){
        return (front == null);
    }

    public void clear(){
        front = null;
        rear = null;
    }



}
