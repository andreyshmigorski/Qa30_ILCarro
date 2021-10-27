package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

@BeforeMethod
public void precondition(){
    if(!app.getUserHelper().isLoginPresent()){
        app.getUserHelper().logout();
    }

}


    @Test
    public void loginSuccess(){
    app.getUserHelper().openLoginForm();
    app.getUserHelper().fillLoginForm("noa@gmail.com","Nnoa12345$");
    app.getUserHelper().submitForm();
        Assert.assertTrue(app.getUserHelper().isLoggedSuccess());


    }
}
