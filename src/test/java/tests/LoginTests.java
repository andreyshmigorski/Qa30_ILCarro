package tests;


import manager.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//@Listeners(NgListener.class)
public class LoginTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (!app.getUserHelper().isLoginPresent()) {
            app.getUserHelper().logout();
        }
    }


    @Test(dataProvider = "loginModelDto",dataProviderClass = MyDataProvider.class)
    public void loginSuccessWithModel(User user) {
       // User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");
        logger.info("With user --> "+user.toString());

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(user);
        app.getUserHelper().submitForm();
        Assert.assertTrue(app.getUserHelper().isLoggedSuccess());
    }




    @Test(dataProvider = "loginDto", dataProviderClass = MyDataProvider.class)
    public void loginSuccessWithSTR(String email, String password) {
        logger.info("Start with email -->" +email + "With password --->" +password);
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(email, password);
        app.getUserHelper().submitForm();
        Assert.assertTrue(app.getUserHelper().isLoggedSuccess());

    }

    @AfterMethod
    public void postCondition() {
        app.getUserHelper().clickOkButton();
    }

}
