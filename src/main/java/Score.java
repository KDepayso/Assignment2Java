public class Score implements Comparable<Score>{

    private final String name;
    private final int score;
    private final int numberOfCardsPerHand;

    public Score(String Name, int Score, int NumberOfCardsPerHand){
        name = Name;
        score = Score;
        numberOfCardsPerHand = NumberOfCardsPerHand;
    }


    @Override
    public int compareTo(Score otherScore){
        return Integer.compare(this.score, otherScore.score);
    }

    @Override
    public String toString(){
        return name + " | " + score + " | " + numberOfCardsPerHand;
    }

    public void display(){
        System.out.println(this + " cards per hand");
    }

}
