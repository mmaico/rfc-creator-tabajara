package uol.rfc.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import uol.rfc.common.BasicScreen;

public class RfcIncidentQueue extends BasicScreen {

    
    @FindBy(xpath = "/html/body/div[4]/form/a[6]")
    WebElement cmChangeListButton;

    public RfcIncidentQueue(WebDriver driver) {
        super(driver);
    }

    public RfcChangeQueue showCmQueue() {
        command.click(cmChangeListButton);
        
        return getNextPage(RfcChangeQueue.class);
    }

}
