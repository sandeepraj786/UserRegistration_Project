package com.bridgelabz;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class UserRegistrationParametrisedTest {
    private String emailTestResult;
    private boolean expectedResult;

    public UserRegistrationParametrisedTest(String emailTestResult, boolean expectedResult){
        this.emailTestResult = emailTestResult;
        this.expectedResult = expectedResult;
    }
    @Parameterized.Parameters
    public static Collection emailData(){
        return Arrays.asList(new Object[][]{
                {"abc@yahoo.com",true},
                {"abc-100@yahoo.com",true},
                {"abc.100@yahoo.com",true},
                {"abc-100@abc.net",true},
                {"abc.100@abc.com.au",true},
                {"abc@1.com",true},
                {"abc@gmail.com.com",true},
                {"abc+100@gmail.com",true},
                {"abc",false},
                {"abc@.com.my",false},
                {"abc123@gmail.a-",false},
                {"abc123@.com",false},
                {"abc123@.com.com",false},
                {".abc@abc.com",true},
                {"abc()*@gmail.com",false},
                {"abc@%*.com",false},
                {"abc..2002@gmail.com",true},
                {"abc.@gmail.com",false},
                {"abc@abc@gmail.com",false},
                {"ab@gmail.com.1a",false},
                {"abc@gmail.com.aa.au",true}


        });

    }
    @Test
    public void givenEmail_WhenValid_ShouldReturnTrue_OR_False() {
        boolean result = UserRegistration.validateEmail(this.emailTestResult);
        Assert.assertEquals(this.expectedResult, result);
    }
}
