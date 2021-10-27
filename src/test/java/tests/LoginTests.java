package tests;


import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
        User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");

    app.getUserHelper().openLoginForm();

    //app.getUserHelper().fillLoginForm("noa@gmail.com","Nnoa12345$");
    app.getUserHelper().fillLoginForm(user);

    app.getUserHelper().submitForm();
    Assert.assertTrue(app.getUserHelper().isLoggedSuccess());


    }
    @Test
    public void loginSuccess2(){
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm("noa@gmail.com","Nnoa12345$");
        app.getUserHelper().submitForm();
        Assert.assertTrue(app.getUserHelper().isLoggedSuccess());

    }
    @AfterMethod
    public void postCondition(){
    app.getUserHelper().clickOkButton();
    }

}
