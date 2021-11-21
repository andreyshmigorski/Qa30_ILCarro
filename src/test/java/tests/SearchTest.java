package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{

    @Test
    public void searchTests(){
        app.search().fillSearchForm("Haifa","11/25/2021","12/27/2021");
        app.getUserHelper().submitForm();

        Assert.assertTrue(app.search().isListOfCarsAppeared());
    }
    @Test(enabled = false)
    public void searchTests2(){
        app.search().fillSearchForm("Haifa","11/25/2021","12/27/2021");
        app.getUserHelper().submitForm();

        Assert.assertTrue(app.search().isListOfCarsAppeared());
    }

    @AfterMethod
    public  void post(){
        app.search().returnToMainPage();
    }
}
