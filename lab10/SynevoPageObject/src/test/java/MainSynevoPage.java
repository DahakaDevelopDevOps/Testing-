import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static webDriver.Browser.driver;

public class MainSynevoPage {
    private static final String MAIN_PAGE_URL = "https://synevo.com.tr/en/";

    @FindBy(xpath = "//div[@class='item']")
    private WebElement changeLanguageButton;

    public MainSynevoPage() {
        PageFactory.initElements(driver, this);
    }

    public MainSynevoPage openPage() {
        driver.get(MAIN_PAGE_URL);
        return this;
    }

    public MainSynevoPage clickChangeLanguageButton() {
        driver.manage().window().fullscreen();
        changeLanguageButton.click();
        return this;
    }


}
