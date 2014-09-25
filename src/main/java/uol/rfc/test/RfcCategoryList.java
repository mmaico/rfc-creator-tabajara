package uol.rfc.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import uol.rfc.common.BasicScreen;

public class RfcCategoryList extends BasicScreen {

    
    @FindBy(xpath = "/html/body/div[4]/form/div/div/table/tbody/tr[4]/td[2]/a")
    WebElement normalUOLCSLink;

    public RfcCategoryList(WebDriver driver) {
        super(driver);
    }

    public RfcChangeOpenPrompt normalUolCs() {
        command.click(normalUOLCSLink);
        return getNextPage(RfcChangeOpenPrompt.class);
    }

}
