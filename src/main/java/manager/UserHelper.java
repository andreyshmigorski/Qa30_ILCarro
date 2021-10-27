package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public void submitForm() {
       // click(By.cssSelector("[type='submit']"));
        WebElement submit= wd.findElement(By.cssSelector("[type='submit']"));
        submit.submit();

    }

    public boolean isLoggedSuccess() {
        WebDriverWait wait = new WebDriverWait(wd,10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container"))));

return wd.findElement(By.cssSelector(".dialog-container h2")).getText().contains("success");
    }
}
