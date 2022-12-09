import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GetIntInputTest {



    @Test
    void tryParseIntRejectsNonNumbers() {
        String notInt = "abcd";
        assertNull(GetIntInput.tryParseInt(notInt));

    }
}