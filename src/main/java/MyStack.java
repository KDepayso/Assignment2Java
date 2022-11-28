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
    public int getSize(){
        return size;
    }

    public T[] toArray(){
        T[] resultArray = (T[]) new Object[size];
        MyStack<T> duplicateStack = this;
        for(int i = 0; i < size; i++){
            if(duplicateStack.peek() != null){
                resultArray[i] = duplicateStack.pop();
            }
        }
        return resultArray;

    }
}
