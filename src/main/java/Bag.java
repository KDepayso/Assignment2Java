public abstract class Bag {

    private final Card[] bag;
    private int numberOfEntries;


    protected Bag(int numCards) {
        bag = new Card[numCards];
    }

    public int getCurrentSize() {
        return numberOfEntries;
    }

    public int getMaximumSize() { return bag.length; }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }


    public boolean addNewEntry(Card newEntry) {
        if (isBagFull() || isCardRepeated(newEntry)) return false;
        else{
            bag[numberOfEntries++] = newEntry;
            return true;
        }
    }

    private boolean isCardRepeated(Card newEntry){
        return this.contains(newEntry);
    }

    private boolean isBagFull(){
        return (bag.length == numberOfEntries);
    }



    public Card remove(Card desiredCard){

        int index = 0;
        while(index < numberOfEntries){
            if(bag[index].equals(desiredCard)){
                return removeElementAt(index);
            }
            else index++;
        }
        return null;
    }

    public void clear() {
        while(!isEmpty()) remove();
    }

    private void remove(){
        removeElementAt(numberOfEntries - 1);
    }

    private Card removeElementAt(int index){
        Card result = null;
        if(!isEmpty() && index >= 00 && index < numberOfEntries){
            result = bag[index];
            bag[index] = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1 ] = null;
            numberOfEntries--;
        }
        return result;
    }

    public boolean contains(Card desiredCard) {
        boolean found = false;
        int index = 0;
        while(!found && index < numberOfEntries)
            if(bag[index++].equals(desiredCard)) found = true;
        return found;
    }


    public Card[] toArray() {
        Card[] resultArray = new Card[numberOfEntries];
        System.arraycopy(bag,0,resultArray,0,numberOfEntries);
        return resultArray;
    }

    @Override
    public String toString(){
        String strResult = "";
        for(int i = 0; i < numberOfEntries; i++)
            strResult += bag[i] + "\n";
        strResult += "";
        return strResult;
    }




}
