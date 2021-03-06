package tests;

import manager.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{
    @BeforeMethod
    public void precondition() {
        if (!app.getUserHelper().isLoginPresent()) {
            app.getUserHelper().logout();
        }
    }

    @Test(dataProvider="registrationCSV",dataProviderClass = MyDataProvider.class)
    public void registrationSuccessTest(User user) {
        logger.info(user.toString());

        app.getUserHelper().openRegistrationForm();
        app.getUserHelper().fillRegistrationForm(user);
        app.getUserHelper().checkPolicy();
        app.getUserHelper().submitForm();
        Assert.assertTrue(app.getUserHelper().isRegistered());
    }
    @Test
    public void registrationPasswordTest() {
        int i = (int)((System.currentTimeMillis()/1000)%3600);

        User user = new User()
                .withName("Lis")
                .withLastname("Snow")
                .withEmail("snow"+i+"@gmail.com")
                .withPassword("S123");

        app.getUserHelper().openRegistrationForm();
        app.getUserHelper().fillRegistrationForm(user);
        app.getUserHelper().checkPolicy();
        Assert.assertTrue(app.getUserHelper().isErrorPasswordDisplayed());
        Assert.assertFalse(app.getUserHelper().isYallaButtonActive());
    }
    @AfterMethod
    public void postCondition(){
        app.getUserHelper().clickOkButton();
    }
}
