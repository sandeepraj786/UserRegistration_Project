package com.bridgelabz;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserRegistrationTest {
    UserRegistration userRegistration;

    public static final String firstNamePattern ="^[A-Z][a-z]{2,}$";
    public static String lastNamePattern = "^[A-Z][a-z]{2,}$";
    private static String email = "^[\\w-_\\.?+]{2,}[\\w]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    private static String phoneNumber ="^[1-9]{2}[-][6-9][0-9]{9}$";

    private static String passwordFirstPattern ="^[a-zA-Z0-9]{8,}";
    private static String passwordSecondPattern = "^[A-Z]{1,}[a-zA-Z0-9]{7,}";
    private static String passwordThirdPattern = "^[0-9]{1,}[a-zA-Z0-9]{7,}";

    @Before
    public void setUp() {
        userRegistration =new UserRegistration();
    }

    @Test
    public void givenFirstName_whenProper_shouldReturnTrue(){
        try {
            String firstName = "Sandeep";
            boolean userFirstName = userRegistration.validateUserFirstName(firstName);
            Assert.assertTrue(userFirstName);
        }catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void givenFirstName_startingWithSmallerLetter_shouldReturnFalse() {
        try {
            String firstName = "sandeep";
            boolean userFirstName = userRegistration.validateUserFirstName(firstName);
            Assert.assertFalse(userFirstName);
        }catch (MyException e){
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void givenFirstName_byLengthWhenInvalid_shouldReturnFalse(){
        String firstName="Sa";
        boolean userFirstName= false;
        try {
            userFirstName = userRegistration.validateUserFirstName(firstName);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertFalse(userFirstName);
    }


    @Test
    public void givenLastName_whenProper_shouldReturnTrue(){
        String lastName="Raj";
        boolean userLastName= false;
        try {
            userLastName = userRegistration.validateUserLastName(lastName);
        } catch (MyException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(userLastName);
    }

    @Test
    public void givenLastName_startingWithSmallerLetter_shouldReturnFalse(){
        String lastName="raj";
        boolean userLastName= false;
        try {
            userLastName = userRegistration.validateUserLastName(lastName);
        } catch (MyException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(userLastName);
    }
    @Test
    public void givenLastName_byLengthWhenInvalid_shouldReturnFalse() {
        String lastName = "Ra";
        boolean userLastName = false;
        try {
            userLastName = userRegistration.validateUserLastName(lastName);
        } catch (MyException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(userLastName);
    }

    @Test
    public void givenMobileNumberWithCountryCode_whenProper_shouldReturnTrue() {
        String mobileNumber="91-8149600728";
        boolean userMobileNumber = false;
        try {
            userMobileNumber = userRegistration.validateUserMobileNumber(mobileNumber);
        } catch (MyException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(userMobileNumber);
    }
    @Test
    public void givenMobileNumberWithoutCountryCode_whenInvalid_shouldReturnFalse() {
        String mobileNumber="8149600728";
        boolean userMobileNumber = false;
        try {
            userMobileNumber = userRegistration.validateUserMobileNumber(mobileNumber);
        } catch (MyException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(userMobileNumber);
    }
    @Test
    public void givenMobileNumberLessThenTenDigit_whenInvalid_shouldReturnFalse() {
        String mobileNumber="91-8149600";
        boolean userMobileNumber = false;
        try {
            userMobileNumber = userRegistration.validateUserMobileNumber(mobileNumber);
        } catch (MyException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(userMobileNumber);
    }

    @Test
    public void givenPasswordHavingMinimumEightCharacters_whenValid_shouldReturnTrue(){
        String password="dgfghhhjA";
        boolean passwordFirstRule = false;
        try {
            passwordFirstRule = userRegistration.validatePasswordFirstRule(password);
        } catch (MyException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(passwordFirstRule);
    }
    @Test
    public void givenPasswordHavingLessThenEightCharacters_whenInvalid_shouldReturnFalse(){
        String password="dghjA";
        boolean passwordFirstRule = false;
        try {
            passwordFirstRule = userRegistration.validatePasswordFirstRule(password);
        } catch (MyException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(passwordFirstRule);
    }
    @Test
    public void givenPasswordHavingAtleastOneUpperCase_whenValid_shouldReturnTrue(){
        String password="Aghhhjjj";
        boolean passwordFirstRule = false;
        try {
            passwordFirstRule = userRegistration.validatePasswordSecondRuleAtleastOneUpperCase(password);
        } catch (MyException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(passwordFirstRule);
    }
    @Test
    public void givenPasswordHavingNotUpperCase_whenInvalid_shouldReturnFalse(){
        String password="rghhhjjj";
        boolean passwordFirstRule = false;
        try {
            passwordFirstRule = userRegistration.validatePasswordSecondRuleAtleastOneUpperCase(password);
        } catch (MyException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(passwordFirstRule);
    }
    @Test
    public void givenPasswordHavingNumericValue_whenInvalid_shouldReturnFalse(){
        String password="23456789";
        boolean passwordFirstRule = false;
        try {
            passwordFirstRule = userRegistration.validatePasswordSecondRuleAtleastOneUpperCase(password);
        } catch (MyException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(passwordFirstRule);
    }
    @Test
    public void givenPasswordHavingAtlasNumericNumber_whenValid_shouldReturnTrue(){
        String password="5kjsgeiei";
        boolean passwordThirdRule = false;
        try {
            passwordThirdRule = userRegistration.validatePasswordThirdRuleAtleastOneNumericNumber(password);
        } catch (MyException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(passwordThirdRule);
    }
    @Test
    public void givenPasswordNotHavingNumericNumber_whenInvalid_shouldReturnFalse(){
        String password="msjbgsswoue";
        boolean passwordThirdRule = false;
        try {
            passwordThirdRule = userRegistration.validatePasswordThirdRuleAtleastOneNumericNumber(password);
        } catch (MyException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(passwordThirdRule);
    }
    @Test
    public void givenPasswordNotHavingEightCharacters_whenInvalid_shouldReturnFalse(){
        String password="09876";
        boolean passwordThirdRule = false;
        try {
            passwordThirdRule = userRegistration.validatePasswordThirdRuleAtleastOneNumericNumber(password);
        } catch (MyException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(passwordThirdRule);
    }
    @Test
    public void givenPasswordNotHavingExactlyOneSpecialCharacters_whenValid_shouldReturnTrue(){
        String password="Sandeep@123";
        boolean passwordRule = false;
        try {
            passwordRule = userRegistration.validatePasswordFourthRuleExactlyOneSpecialCharacter(password);
        } catch (MyException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(passwordRule);
    }

    @Test
    public void givenFirstname_whenProper_shouldReturnTrue(){
        boolean result= userRegistration .validation("Sandeep" ,firstNamePattern);
        Assert.assertTrue(result);
    }
    @Test
    public void givenFirstname_startingWithSmallerLetter_shouldReturnFalse() {
        boolean result= userRegistration.validation("sandeep" ,firstNamePattern);
        Assert.assertFalse(result);
    }

    @Test
    public void givenFirstname_byLengthWhenInvalid_shouldReturnFalse(){
        boolean result= userRegistration.validation("Sa" ,firstNamePattern);
        Assert.assertFalse(result);
    }
    @Test
    public void givenLastname_whenProper_shouldReturnTrue(){
        boolean result= userRegistration.validation("Raj" ,lastNamePattern);
        Assert.assertTrue(result);
    }
    @Test
    public void givenLastname_startingWithSmallerLetter_shouldReturnFalse() {
        boolean result= userRegistration.validation("sandeep" ,lastNamePattern);
        Assert.assertFalse(result);
    }

    @Test
    public void givenLastname_byLengthWhenInvalid_shouldReturnFalse(){
        boolean result= userRegistration.validation("Ra",lastNamePattern);
        Assert.assertFalse(result);
    }
    @Test
    public void givenMobilenumberWithCountryCode_whenProper_shouldReturnTrue() {
        boolean result= userRegistration.validation("91-8149600728" ,phoneNumber);
        Assert.assertTrue(result);
    }
    @Test
    public void givenMobilizerWithoutCountryCode_whenInvalid_shouldReturnFalse() {
        boolean result= userRegistration.validation("8149600728" ,phoneNumber);
        Assert.assertFalse(result);
    }
    @Test
    public void givenMobilizerLessThenTenDigit_whenInvalid_shouldReturnFalse() {
        boolean result= userRegistration.validation("91-81497000" ,phoneNumber);
        Assert.assertFalse(result);

    }
    @Test
    public void givenPasswordHavingMinimizedCharacters_whenValid_shouldReturnTrue(){
        boolean result= userRegistration.validation("dfgkljhgf" ,passwordFirstPattern);
        Assert.assertTrue(result);
    }
    @Test
    public void givenPasswordHavingLessHeightCharacters_whenInvalid_shouldReturnFalse(){
        boolean result= userRegistration.validation("jhegeu" ,passwordFirstPattern);
        Assert.assertFalse(result);
    }
    @Test
    public void givenPasswordHeavinessOneUpperCase_whenValid_shouldReturnTrue(){
        boolean result= userRegistration.validation("Srvfdeks" ,passwordSecondPattern);
        Assert.assertTrue(result);
    }
    @Test
    public void givenPasswordHavingUpperCase_whenInvalid_shouldReturnFalse(){
        boolean result= userRegistration.validation("poiuytreweq" ,passwordSecondPattern);
        Assert.assertFalse(result);
    }
    @Test
    public void givenPasswordHaving_NumericValue_whenInvalid_shouldReturnFalse() {
        boolean result = userRegistration.validation("87654324567", passwordSecondPattern);
        Assert.assertFalse(result);
    }
}
