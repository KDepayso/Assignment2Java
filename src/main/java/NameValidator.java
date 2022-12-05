import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator {


    public NameValidator(){
    }

    private boolean isNameTooLong(String name){
        return name.length() >= 30;
    }

    //Allows other Unicode letters other than ASCII, to allow names with accents to be accepted.
    private boolean doesNameContainNonLetters(String name){
        return !name.matches("^[\\p{L} .'-]+$");
    }

    public boolean isNameValid(String name){
        if(isNameTooLong(name)) return false;
        if(doesNameContainNonLetters(name)) return false;

        return true;
    }
}
