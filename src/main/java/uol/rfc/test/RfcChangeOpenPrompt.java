package uol.rfc.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import uol.rfc.common.BasicScreen;
import uol.rfc.common.utils.RfcLogout;

public class RfcChangeOpenPrompt extends BasicScreen {

    @FindBy(xpath = "/html/body/div[4]/form/div/div/div/input")
    WebElement plannedStartInput;
    
    @FindBy(xpath = "/html/body/div[4]/form/div[3]/div/div/input")
    WebElement plannedEndInput;
    
    @FindBy(xpath = "/html/body/div[4]/form/div[7]/div/div/input")
    WebElement categoryInput;
   
    @FindBy(xpath = "/html/body/div[4]/form/div[9]/div/div/input")
    WebElement reasonForChangeInput;
    
    @FindBy(xpath = "/html/body/div[4]/form/div[10]/div[2]/div/div/div/input")
    WebElement changeEnvironment;
    
    @FindBy(xpath = "/html/body/div[4]/form/div[10]/div/div/a")
    WebElement generalTab;
    
    @FindBy(xpath = "/html/body/div[4]/form/div[10]/div/div[3]/a")
    WebElement descriptionTab;
    
    @FindBy(xpath = "/html/body/div[4]/form/div[10]/div[2]/div[4]/div/div/input")
    WebElement projectNameInput;
    
    @FindBy(xpath = "/html/body/div[4]/form/div[10]/div[2]/div[11]/div/input")
    WebElement dbaNecessary;
    
    @FindBy(xpath = "/html/body/div[4]/form/div[10]/div[2]/div[11]/div[2]/input")
    WebElement dbaNotNecessary;
    
    @FindBy(xpath = "/html/body/div[4]/form/div[10]/div[2]/div[17]/div[2]/input")
    WebElement changeArchitecture;
    

    public RfcChangeOpenPrompt(WebDriver driver) {
        super(driver);
    }

    public RfcChangeOpenPrompt plannedStartAndEndDates() {
        command.type(plannedStartInput, "00:00:00");
        command.type(plannedEndInput, "23:59:59");
        return this;
    }
    
    public RfcChangeOpenPrompt changeCategoryToMinor() {
        command.type(categoryInput, "3 - Minor Change");
        return this;
    }
    
    public RfcChangeOpenPrompt reasonBusinessRequirement() {
        command.type(reasonForChangeInput, "Business Requirement");
        return this;
    }
    
    public RfcChangeOpenPrompt switchToGeneralTap() {
        command.click(generalTab);
        return this;
    }
    
    public RfcChangeOpenPrompt changeEnvironmentProductionPortal() {
        command.type(changeEnvironment, "Portal Produção");
        return this;
    }
    
    public RfcChangeOpenPrompt projectNameChange() {
        command.type(projectNameInput, "cadastro");
        return this;
    }
    
    public RfcChangeOpenPrompt isNotNecessaryDBA() {
        command.click(dbaNotNecessary);
        return this;
    }
    
    public RfcChangeOpenPrompt changeArchitecture() {
        command.click(changeArchitecture);
        return this;
    }
    
    public RfcChangeOpenPrompt done() {
   
        RfcLogout.logout(command);
        return getNextPage(RfcChangeOpenPrompt.class);
    }

}
