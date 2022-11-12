import java.util.EmptyStackException;

public class Stack<T> {

    private MyNode<T> topNode;

    public Stack() {
        topNode = null;
    }

    public void push (T newEntry){

        MyNode<T> newNode = new MyNode<>(newEntry);
        newNode.setNextNode(topNode);
        topNode = newNode;

    }


    public T pop(){

        T dataToReturn = peek();
        topNode = topNode.getNextNode();
        return dataToReturn;
    }

    public T peek(){

        if(topNode== null) throw new EmptyStackException();
        else return topNode.getData();

    }

    public boolean isEmpty(){

        return (topNode == null);
    }

    public void clear(){

        topNode = null;

    }
}
