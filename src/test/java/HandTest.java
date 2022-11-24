import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    void generateDifferentHandSizes(){
        Hand hand = new Hand(5);
        assertEquals(5,hand.getCurrentSize());

        Hand hand2 = new Hand(10);
        assertEquals(10,hand.getCurrentSize());
    }


}