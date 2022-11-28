public class MyNode<T> {
    private T data;
    private MyNode<T> nextMyNode;

    public MyNode(T dataValue){
        data = dataValue;
        nextMyNode = null;
    }

    public T getData() {

        return data;
    }

    public void setData(T data) {

        this.data = data;
    }

    public MyNode<T> getNextNode() {

        return nextMyNode;
    }

    public void setNextNode(MyNode<T> myNode) {

        nextMyNode = myNode;
    }

}
