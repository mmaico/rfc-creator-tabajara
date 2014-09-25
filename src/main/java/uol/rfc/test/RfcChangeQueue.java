package uol.rfc.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import uol.rfc.common.BasicScreen;

public class RfcChangeQueue extends BasicScreen {

    
    @FindBy(xpath = "/html/body/div[4]/form/div[3]/fieldset/div/input")
    WebElement newRfcButton;

    public RfcChangeQueue(WebDriver driver) {
        super(driver);
    }

    public RfcCategoryList listRfcCategories() {
        command.click(newRfcButton);
       
        return getNextPage(RfcCategoryList.class);
    }

}
