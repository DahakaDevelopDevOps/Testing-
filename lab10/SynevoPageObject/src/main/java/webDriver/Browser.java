package webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
    public static WebDriver driver = null;

    public Browser() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Watcher/Desktop/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    public WebDriver getDriver() {
        return driver;
    }

}
