import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

public class MyStack<T> {

    private MyNode<T> topNode;
    private int size;

    public MyStack() {

        topNode = null;
        size = 0;
    }

    public void push (T newEntry){

        MyNode<T> newNode = new MyNode<>(newEntry);
        newNode.setNextNode(topNode);
        topNode = newNode;
        size++;

    }


    public T pop(){

        T dataToReturn = peek();
        topNode = topNode.getNextNode();
        size--;
        return dataToReturn;
    }

    public T peek(){

        if(topNode== null) throw new EmptyStackException();
        else return topNode.getData();

    }

    public MyNode<T> getTopNode(){
        return this.topNode;
    }

    public boolean isEmpty(){

        return (topNode == null);
    }

    public void clear(){

        topNode = null;
        size = 0;

    }
    public int getSize(){
        return size;
    }

    public void copy(MyStack<T> otherStack){
        this.size = otherStack.getSize();
        this.topNode = otherStack.getTopNode();

    }

}
