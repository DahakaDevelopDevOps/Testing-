import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static webDriver.Browser.driver;

public class SynevoBranchPage {
    private static final String SYNEVO_BRANCH_PAGE = "https://synevo.com.tr/en/Synevo-Bakirkoy-Branch";

    @FindBy(xpath = "//input[@class='form-control']")
    private WebElement searchBar;

    @FindBy(xpath = "//input[@class='form-control']")
    private WebElement inputAddressField;

    @FindBy(xpath = "//span[@class='glyphicon glyphicon-remove pull-right mapErrorClose']")
    private List<WebElement> errorMessage;

    public SynevoBranchPage openPage() {
        driver.get(SYNEVO_BRANCH_PAGE);
        return this;
    }

    public SynevoBranchPage() {
        PageFactory.initElements(driver, this);
    }

    public SynevoBranchPage enterDataIntoInputField(String inputData) {
        inputAddressField.sendKeys(inputData);
        return this;
    }
    public SynevoBranchPage submitData() {
        inputAddressField.submit();
        return this;
    }
    public boolean isErrorMessageDisplayed(){
        return !errorMessage.stream()
                .findFirst()
                .isEmpty();
    }

}
