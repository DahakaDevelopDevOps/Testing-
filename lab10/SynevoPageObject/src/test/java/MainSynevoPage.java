import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webDriver.Browser;

import static webDriver.Browser.driver;

public class MainSynevoPage {
    private static final String MAIN_PAGE_URL = "https://synevo.com.tr/en/";

    @FindBy(xpath = "//a[@class='dropdown-toggle mmItem'][@alt='About Us']")
    private WebElement navigationButtonToMainInformationPage;

    public MainSynevoPage() {
        PageFactory.initElements(driver, this);
    }

    public MainSynevoPage openPage() {
        driver.get(MAIN_PAGE_URL);
        driver.manage().window().fullscreen();
        return this;
    }

    public SynevoBranchPage chooseMenuOption() {
        navigationButtonToMainInformationPage.click();
        return new SynevoBranchPage();
    }


}
