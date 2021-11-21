package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    EventFiringWebDriver wd;
    UserHelper userHelper;
    CarHelper car;
    SearchHelper search;
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init(){
        if (browser.equals(BrowserType.CHROME)) {
            wd = new EventFiringWebDriver(new ChromeDriver());
            logger.info("Tests starts on Chrome Driver");
        }else if (browser.equals(BrowserType.FIREFOX)){
            wd= new EventFiringWebDriver(new FirefoxDriver());
            logger.info("Tests starts on FireFox Driver");
        }

        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.xyz/search");
        logger.info("Navigate to link ---> " + wd.getCurrentUrl());
        wd.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        wd.register( new MyListener());
        userHelper =new UserHelper(wd);
        car = new CarHelper(wd);
        search = new SearchHelper(wd);


    }
    public void stop(){
        logger.info("The browser  has been closed");
        wd.quit();
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public CarHelper getCar() {
        return car;
    }

    public SearchHelper search() {
        return search;
    }
}
