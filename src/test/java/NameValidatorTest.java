import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameValidatorTest {

    static NameValidator nameValidator = new NameValidator();

    @Test
    void isNameTooLongRejected(){
        //Name with over 30 characters
        String invalidName = "abcdefghijklmnopqrstuvwxyzabcde";

        assertFalse(nameValidator.isNameValid(invalidName));

    }

    @Test
    void isNameWithNumbersRejected(){
        String invalidName = "12345";

        assertFalse(nameValidator.isNameValid(invalidName));
    }

    @Test
    void isNullNameRejected(){
        String invalidName = "";

        assertFalse(nameValidator.isNameValid(invalidName));
    }

    @Test
    void isValidNameAccepted(){
        String validName = "Validname";

        assertTrue(nameValidator.isNameValid(validName));
    }
}