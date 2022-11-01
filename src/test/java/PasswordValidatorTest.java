import PasswordValidator.PasswordValidator;
import jdk.jfr.StackTrace;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    @Test
    void passwordTooShort(){
        Assertions.assertEquals(false, PasswordValidator.isLongerThan7("1234567"));
    }
    @Test
    void passwordIsLongEnough(){
        Assertions.assertEquals(true, PasswordValidator.isLongerThan7("12345678"));

    }
    @Test
    void passwordContainsDigit(){
        Assertions.assertEquals(true, PasswordValidator.containsDigit("test123"));
    } @Test
    void passwordContainsNoDigit(){
        Assertions.assertEquals(false, PasswordValidator.containsDigit("testABC"));
    }
    @Test
    void passwordContainsNoDigitButIsLongEnough(){
        Assertions.assertEquals(false, PasswordValidator.isValid("IchBinLangGenug"));
    }
     @Test
    void passwordContainsDigitButIsNotLongEnough(){
        Assertions.assertEquals(false, PasswordValidator.isValid("IchBin1"));
    }
    @Test
    void passwordContainsDigitAndIsLongEnoughButOnlyUpperCase(){
        Assertions.assertEquals(false, PasswordValidator.isValid("PASSWORD1"));
    }
    @Test
    void passwordContainsDigitAndIsLongEnoughButOnlyLowerCase(){
        Assertions.assertEquals(false, PasswordValidator.isValid("password1"));
    }
    @Test
    void passwordContainsDigitAndIsLongEnoughAndContainsUpperCaseAndContainsLowerCaseButIsProhibited(){
        Assertions.assertEquals(false, PasswordValidator.isValid("Password1"));
    }

    @Test
    void passwordisValid(){
        Assertions.assertEquals(true, PasswordValidator.isValid("Test1234567"));
    }

    @Test
    void passwordcontainsLowerCase(){
        Assertions.assertEquals(true, PasswordValidator.containsLowerCase("a"));
    }

    @Test
    void passwordDoesNotContainLowerCase(){
        Assertions.assertEquals(false, PasswordValidator.containsLowerCase("A"));
    }
    @Test
    void passwordWithSSContainLowerCase(){
        Assertions.assertEquals(true, PasswordValidator.containsLowerCase("ß"));
    }
    @Test
    void passwordContainsUpperCase(){
        Assertions.assertEquals(true, PasswordValidator.containsUpperCase("A"));
    }
    @Test
    void passwordIsPassword1(){
        Assertions.assertEquals(true, PasswordValidator.isInSetOfProhibitedTests("Password1"));
    }
    @Test
    void passwordIsMarmeladenBrot123(){
        Assertions.assertEquals(false, PasswordValidator.isInSetOfProhibitedTests("MarmeladenBrot123"));
    }
  @Test
    void passwordIsGeheim123(){
        Assertions.assertEquals(true, PasswordValidator.isInSetOfProhibitedTests("Geheim123"));
    }


}
