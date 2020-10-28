package com.bridgelabz;

import java.util.regex.Pattern;
@FunctionalInterface
interface IUserRegistration {

    boolean validateUser(String userInput,String pattern);
}

public class UserRegistration {
    private static Pattern firstnamePattern = Pattern.compile("^[A-Z][a-z]{2,}$");
    private static Pattern lastNamePattern = Pattern.compile("^[A-Z][a-z]{2,}$");
    private static Pattern eMailId = Pattern.compile("^[\\w-_\\.?+]{2,}[\\w]\\@([\\w]+\\.)+[\\w]+[\\w]$");
    private static Pattern phoneNumber =Pattern.compile("^[1-9]{2}[-][6-9][0-9]{9}$");
    private static Pattern passwordFirstPattern =Pattern.compile("^[a-zA-Z0-9]{8,}");
    private static Pattern passwordSecondPattern = Pattern.compile("^[A-Z]{1,}[a-zA-Z0-9]{7,}");
    private static Pattern passwordThirdPattern = Pattern.compile("^[0-9]{1,}[a-zA-Z0-9]{7,}");
    private static Pattern passwordFourthPattern = Pattern.compile("^[A-Z0-9a-z.%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}");
    boolean isValid = false;

    public boolean validateUserFirstName(String firstName) throws MyException {
        isValid= firstnamePattern.matcher(firstName).matches();
        if(!isValid){
            throw new MyException("GiveProperName");
        }
        return isValid;
    }

    public boolean validateUserLastName(String lastName)throws MyException{
        isValid= lastNamePattern.matcher(lastName).matches();
        if(!isValid){
            throw new MyException("giveProperLastName");
        }
        return isValid;
    }

    public static boolean validateEmail(String email)  {
        return eMailId.matcher(email).matches();
    }

    public boolean validateUserMobileNumber(String mobileNumber) throws MyException {
        isValid= phoneNumber.matcher(mobileNumber).matches();
        if(!isValid){
            throw new MyException("phone number is not correct");
        }
        return isValid;
    }

    public boolean validatePasswordFirstRule(String password) throws MyException{
        isValid= passwordFirstPattern.matcher(password).matches();
        if(!isValid){
            throw new MyException("Give proper password");
        }
        return isValid;

    }

    public boolean validatePasswordSecondRuleAtleastOneUpperCase(String password) throws MyException{
        isValid= passwordSecondPattern.matcher(password).matches();
        if(!isValid){
            throw new MyException("Password is not correct");
        }
        return isValid;
    }

    public boolean validatePasswordThirdRuleAtleastOneNumericNumber(String password) throws MyException{
        isValid= passwordThirdPattern.matcher(password).matches();
        if(!isValid){
            throw new MyException("Give proper password");
        }
        return isValid;

    }
    public boolean validatePasswordFourthRuleExactlyOneSpecialCharacter(String password) throws MyException{
        isValid= passwordFourthPattern.matcher(password).matches();
        if(!isValid){
            throw new MyException("Give proper password");
        }
        return isValid;
    }

    public boolean validation(String name,String Pattern){
        IUserRegistration iUserRegistration = ((userInput, pattern) -> userInput.matches(pattern));
        return iUserRegistration.validateUser(name,Pattern);
    }


}

