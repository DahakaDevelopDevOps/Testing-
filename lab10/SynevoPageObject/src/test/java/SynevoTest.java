import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import webDriver.Browser;


public class SynevoTest {
    Browser driver = null;

    @BeforeMethod(alwaysRun = true)
    public void setUpDriver() {
        driver = new Browser();
    }

    @Test(description = "Test changing language operation")
    public void testChangeLanguage() {
        MainSynevoPage page = new MainSynevoPage();
        page.openPage()
                .clickChangeLanguageButton();
        Assert.assertEquals(driver.getDriver().getCurrentUrl(), "https://synevo.com.tr/tr/", "URL is not correct");

    }

    @Test(description = "Test error message when client enter incorrect route")
    public void testIncorrectRoute() {
        SynevoBranchPage branchPage = new SynevoBranchPage();
        branchPage.openPage()
                .enterDataIntoInputField("1")
                .submitData();
        Assert.assertFalse(branchPage.isErrorMessageDisplayed(), "Should be error message!");
    }

    @AfterMethod(alwaysRun = true)
    public void closeWebPage() {
        driver.getDriver().quit();
        driver = null;
    }
}
