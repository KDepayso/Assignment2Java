public final class Deck<T>{

    private T[] deck;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 52;
    private boolean initialised = false;



    public Deck() {

        T[] tempBag = (T[]) new Object[52];
        deck = tempBag;
        numberOfEntries = 0;
        initialised = true;

    }


    public void generateStackOfCards(){

        Stack<Card> cardStack = new Stack<Card>();

        for(Suits suits : Suits.values()){

            for(Ranks ranks : Ranks.values()){

                Card newCard = new Card(ranks,suits);
                addNewEntry((T)newCard);

            }
        }
    }




    public int getCurrentSize() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;

    }

    public boolean addNewEntry(T newEntry) {
        checkInitialisation();
        if (isArrayFull()) return false;
        else{
            deck[numberOfEntries++] = newEntry;
            return true;
        }

    }

    public T remove() {
        checkInitialisation();
        return removeElementAt(numberOfEntries - 1);

    }

    public boolean remove(T anEntry) {
        boolean found = false;
        int index = 0;
        while(!found && index < numberOfEntries)
            if(deck[index].equals(anEntry)) found = true;
            else index++;
        if(found) removeElementAt(index);
        return found;

    }

    public void clear() {
        while(!isEmpty()) remove();
    }

    public int getFrequencyOf(T anEntry) {
        int count = 0;
        for (int i = 0; i <numberOfEntries; i++)
            if (deck[i].equals(anEntry)) count++;
        return count;

    }

    public boolean contains(T anEntry) {
        boolean found = false;
        int index = 0;
        while(!found && index < numberOfEntries)
            if(deck[index++].equals(anEntry)) found = true;
        return found;

    }

    public T[] toArray() {
        T[] resultArray = (T[]) new Object[numberOfEntries];
        System.arraycopy(deck,0,resultArray,0,numberOfEntries);
        return resultArray;

    }

    private boolean isArrayFull(){
        return (deck.length == numberOfEntries);
    }

    private void checkInitialisation(){
        if(!initialised)
            throw new SecurityException("ArrayBag object could not be initialised properly");
    }

    private T removeElementAt(int index){
        T result = null;
        if(!isEmpty() && index >= 00 && index < numberOfEntries){
            result = deck[index];
            deck[index] = deck[numberOfEntries - 1];
            deck[numberOfEntries - 1 ] = null;
            numberOfEntries--;

        }
        return result;
    }

    public String toString(){
        String strResult = "Bag[";
        for(int i = 0; i < numberOfEntries; i++)
            strResult += deck[i] + " ";
        strResult += "]";
        return strResult;
    }

    public void display(){
        displayArray(0,numberOfEntries - 1);
    }

    private void displayArray(int first, int last){

        if(first <= last){
            System.out.println(deck[last]);
            displayArray(first , last - 1);
        }

    }


}









