package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends HelperBase{

    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public boolean isLoginPresent() {
        return isElementPresent(By.xpath("//a[text()=' Log in ']"));
    }

    public void logout() {
        click(By.xpath("//a[text()=' Logout ']"));
    }

    public void openLoginForm() {
        click(By.xpath("//a[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.id("email"),email);
        type(By.id("password"),password);
    }
    public void fillLoginForm(User user) {
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void submitForm() {
       // click(By.cssSelector("[type='submit']"));
        WebElement submit= wd.findElement(By.cssSelector("[type='submit']"));
        new WebDriverWait(wd,10)
                .until(ExpectedConditions.elementToBeClickable(submit));

        submit.submit();

    }

    public boolean isLoggedSuccess() {
        WebDriverWait wait = new WebDriverWait(wd,10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container"))));

return wd.findElement(By.cssSelector(".dialog-container h2")).getText().contains("success");
    }

    public void clickOkButton() {

        if(isElementPresent(By.xpath("//button[text()='Ok']"))){
            click(By.xpath("//button[text()='Ok']"));
        }
    }

    public void login(User user) {
        openLoginForm();
        fillLoginForm(user);
        submitForm();
        clickOkButton();
    pause(1000);
    }

    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLastname());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());

    }

    public boolean isRegistered() {
        WebDriverWait wait = new WebDriverWait(wd,10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container"))));

        return wd.findElement(By.cssSelector(".dialog-container h1")).getText().contains("Registered");
    }

    public void checkPolicy() {
        boolean isselected = wd.findElement(By.id("terms-of-use")).isSelected();
        if(!isselected) {
            click(By.xpath("//label[@for='terms-of-use']"));
        }
        //click(By.id("terms-of-use"));

        // click(By.cssSelector("label[for='terms-of-use']")); //===click(By.xpath("//label[contains(text(),'I agree to the')]"));
        // click(By.cssSelector(".checkbox-container input")) ====click(By.id("terms-of-use"));
//        click(By.cssSelector(".checkbox-container"));
//        click(By.cssSelector(".checkbox-container"));

//        JavascriptExecutor js= (JavascriptExecutor) wd;
//        js.executeScript("document.querySelector('#terms-of-use').click();");
//        js.executeScript("document.querySelector('#terms-of-use').checked=true;");
//        click(By.id("email"));
//        Actions actions = new Actions(wd);
//        WebElement container = wd.findElement(By.cssSelector(".checkbox-container"));
//
//        Rectangle rect = container.getRect();
//       // int x= rect.getX() + rect.getWidth()/10;
//        int x= rect.getX() + 5;
//        int y = rect.getY()+(rect.getHeight()/4);
//     actions.moveByOffset(x,y).click().perform();
    }


    public boolean isErrorPasswordDisplayed() {

        return isElementPresent(By.xpath("//*[text()='Password must contain minimum 8 symbols']"));

    }
    public boolean isYallaButtonActive() {
        return wd.findElement(By.xpath("//button[@type='submit']")).isEnabled();
        // return isElementPresent(By.xpath("//button[@disabled]"));
    }
}
