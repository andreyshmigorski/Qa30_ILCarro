package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{

    @Test
    public void searchTests(){
        app.search().fillSearchForm("Haifa","11/25/2021","11/30/2021");
        //app.search().clickYallaButton();
        app.getUserHelper().submitForm();

        //Assert.assertTrue(app.search().isListOfCarsAppeared());
    }
}
