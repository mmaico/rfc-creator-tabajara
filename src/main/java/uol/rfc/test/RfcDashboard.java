package uol.rfc.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import uol.rfc.common.BasicScreen;

public class RfcDashboard extends BasicScreen {

    
    @FindBy(xpath = "/html/body/div[4]/form/div[2]/div[2]/div[2]/fieldset/a")
    WebElement viewWorkQueuesButton;

    public RfcDashboard(WebDriver driver) {
        super(driver);
    }

    public RfcIncidentQueue showViewWorkQueues() {
        command.click(viewWorkQueuesButton);
        return getNextPage(RfcIncidentQueue.class);
    }

}
