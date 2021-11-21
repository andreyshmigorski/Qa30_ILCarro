package tests;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(app.getUserHelper().isLoginPresent()){
            app.getUserHelper().login(new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$"));
        }

    }

    @Test
    public void addNewCarTestPositive(){
        int i= (int)((System.currentTimeMillis()/1000)%3600);
        Car car = Car.builder()
                .address("Tel Aviv")
                .make("BMW")
                .model("M5")
                .year("2020")
                .engine("2.3")
                .fuel("Petrol")
                .gear("MT")
                .wD("AWD")
                .doors("5")
                .seats("4")
                .clasS("C")
                .fuelConsumption("6.5")
                .carRegNumber("100-55-"+i)
                .price("65")
                .distanceIncluded("500")
                .typeFeature("type of")
                .about("Very nice car")
                .build();
        app.getCar().openCarForm();
        app.getCar().fillCarForm(car);
        app.getCar().attachedPhoto("/Users/tayahatum/Qa30/Qa30_ILCarro/auto2.jpeg");
        app.getUserHelper().submitForm();
        Assert.assertTrue(app.getCar().isCarAdded());

    }
    @Test
    public void addNewCarTestPositive2(){
        int i= (int)((System.currentTimeMillis()/1000)%3600);
        Car car1 = Car.builder()
                .model("ggg")
                .about("jhgg").build();

        Car car = Car.builder()
                .address("Tel Aviv")
                .make("BMW")
                .model("M5")
                .year("2020")
                .engine("2.3")
                .fuel("Petrol")
                .gear("MT")
                .wD("AWD")
                .doors("5")
                .seats("4")
                .clasS("C")
                .fuelConsumption("6.5")
                .carRegNumber("100-55-"+i)
                .price("65")
                .distanceIncluded("500")
                .typeFeature("type of")
                .about("Very nice car")
                .build();
        app.getCar().openCarForm();
        app.getCar().fillCarForm(car);
        app.getCar().attachedPhoto("/Users/tayahatum/Qa30/Qa30_ILCarro/auto.jpeg");
        app.getUserHelper().submitForm();
        Assert.assertTrue(app.getCar().isCarAdded());

    }

//    @AfterMethod
//    public void posCondition(){
//        app.getCar().submitAddedCar();
//        app.getUserHelper().logout();
//
//    }
}
