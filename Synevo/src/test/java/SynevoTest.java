import listener.RetryAnalyzer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SynevoTest {
    WebDriver driver = null;

    @BeforeMethod(alwaysRun = true)
    public void setUpDriver() {
        driver = new ChromeDriver();
    }

    @Test(description = "Test changing language operation", retryAnalyzer = RetryAnalyzer.class)
    public void testChangeLanguage() {
        driver.get("https://synevo.com.tr/en/");
        driver.manage().window().fullscreen();
        WebElement element = setWebElement(By.xpath("//div[@class='item']"));
        element.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://synevo.com.tr/tr/", "URL is not correct");

    }

    @Test( description = "Test navigation to synevo's branch in chosen city. " , retryAnalyzer = RetryAnalyzer.class)
    public void testChooseDedication() {
        driver.get("https://synevo.com.tr/en/");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        WebElement chooseCityButton = setWebElement(By.xpath("//button[@class='btn btn-info']"));
        chooseCityButton.click();
        WebElement cityElement = setWebElement(By.xpath("//a[@href='javascript:void(0);']"));
        cityElement.click();
        WebElement branchElement = setWebElement(By.xpath("//a[@href='/en/Synevo-Bakirkoy-Branch']"));
        branchElement.click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        Assert.assertEquals(driver.getCurrentUrl(), "https://synevo.com.tr/en/Synevo-Bakirkoy-Branch", "URL is not correct");

    }

    @Test( description = "Test searchbar that navigate to over pages", retryAnalyzer = RetryAnalyzer.class)
    public void testSearchBar() {
        driver.get("https://synevo.com.tr/en/Synevo-in-Turkey");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        WebElement searchBar = setWebElementLocation(By.xpath("//input[@rel='subSearch']"));
        searchBar.sendKeys("Our Team"); //
        List<WebElement> elements = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
        Assert.assertFalse(elements.isEmpty(), "Problem with search bar. Can't choose and enter our option");
    }

    @Test(description = "Test site navigation ", retryAnalyzer = RetryAnalyzer.class)
    public void testNavigation() {
        driver.get("https://synevo.com.tr/en/");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        List<WebElement> navigationButton = driver.findElements(By.xpath("//a[@class='dropdown-toggle mmItem']"));
        navigationButton.get(4).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://synevo.com.tr/en/Synevo-in-Turkey", "URL is not correct");
    }

    @Test( description = "Test error message wheb client enter incorrect route", retryAnalyzer = RetryAnalyzer.class)
    public void testIncorrectRoute() {
        driver.get("https://synevo.com.tr/en/Synevo-Bakirkoy-Branch");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        WebElement searchBar = setWebElement(By.xpath("//input[@class='form-control']"));
        searchBar.sendKeys("1");
        WebElement submitButton = setWebElement(By.xpath("//button[@type='submit']"));
        submitButton.click();
        List<WebElement> errorMessage = driver.findElements(By.xpath("//span[@class='glyphicon glyphicon-remove pull-right mapErrorClose']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertFalse(!errorMessage.isEmpty(), "Should be error message!");
    }

    @Test( description = "Test slider in main page", retryAnalyzer = RetryAnalyzer.class)
    public void testSlider() {
        driver.get("https://synevo.com.tr/en/");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        WebElement arrow = setWebElementLocation(By.xpath("//img[@src='/assets/img/bannerNextIco.png']"));
        arrow.click();
        arrow.click();
        List<WebElement> slider = driver.findElements(By.xpath("//div[@class='owl-item active']//canvas[@id='myCanvas45']"));
        Assert.assertFalse(slider.isEmpty(), "Slider doesn't work");
    }

    @Test(description = "Test how site resend to registration page to show client results ", retryAnalyzer = RetryAnalyzer.class)
    public void testAnalysesResultPageWithoutRegistration() {
        driver.get("https://synevo.com.tr/en/");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        WebElement testButton = setWebElement(By.xpath("//a[@class='testSonuc']"));
        testButton.click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
        String handle = driver.getWindowHandles().toArray()[1]
                .toString();
        driver.switchTo().window(handle);
        Assert.assertEquals(driver.getCurrentUrl(), "https://lis.synevo.com.tr/Login.aspx?bireysel", "Url is not correct");
    }

    @Test(description = "Test how site can correct delete all cookies", retryAnalyzer = RetryAnalyzer.class)
    public void testDeleteCookies() {
        driver.get("https://synevo.com.tr/en/");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        Assert.assertEquals(driver.manage().getCookies().size(), 0, "Problems with cookies");
    }

    @Test(description = "User should can open social sites links", retryAnalyzer = RetryAnalyzer.class)
    public void testSocialSitesLinks() {
        driver.get("https://synevo.com.tr/en/");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        WebElement testButton = setWebElement(By.xpath("//a[@class='sIcon f-link']"));
        testButton.click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        String handle = driver.getWindowHandles().toArray()[1]
                .toString();
        driver.switchTo().window(handle);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/SynevoTR", "Url is not correct");

    }
    @DataProvider(name = "testEmails")
    public Object[][] createIncorrectEmail() {
        return new Object[][] {
                { new String("user@.com") },
                { new String("йййй@ййй.ййй ") },
                { new String("   ") },
                { new String("user@..com ") },
                { new String("user@domain.") },
        };
    }
    @Test(dataProvider ="testEmails", description = "Test incorrect emails", retryAnalyzer = RetryAnalyzer.class)
    public void testIncorrectEmails( String email){
        driver.get("https://synevo.com.tr/en/");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        WebElement searchBar = setWebElement(By.xpath("//input[@class='form-control newsletterInput form-obl']"));
        searchBar.sendKeys(email);
        WebElement submitButton = setWebElement(By.xpath("//button[@type='submit']"));
        submitButton.click();
        List<WebElement> errorMessage = driver.findElements(By.xpath("//div[@class='alert resultAlert alert-danger']"));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        Assert.assertFalse(errorMessage.isEmpty(), "Should be error message!");
    }

    @AfterMethod (alwaysRun = true)
    public void closeWebPage() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
        driver.quit();
        driver = null;

    }

    private WebElement setWebElement(By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    private WebElement setWebElementLocation(By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }


}
