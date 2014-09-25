package uol.rfc.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import uol.rfc.common.BasicScreen;

public class RfcLogin extends BasicScreen {

    
    @FindBy(xpath = "/html/body/div[4]/form/div/input")
    WebElement loginInput;

    @FindBy(xpath = "/html/body/div[4]/form/div[2]/input")
    WebElement passInput;

    @FindBy(xpath = "/html/body/div[4]/form/div[3]/input")
    WebElement signInButton;

    public RfcLogin(WebDriver driver) {
        super(driver);
    }

    public RfcDashboard doLogin() {
        command.type(loginInput, "cad_mjesus");
        command.type(passInput, "work@uol02");
        command.click(signInButton);
        return getNextPage(RfcDashboard.class);
    }

}
