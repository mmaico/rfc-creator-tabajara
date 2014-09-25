package uol.rfc.test;
import org.openqa.selenium.WebDriver;

import uol.rfc.common.BasicScreen;
import uol.rfc.common.ChromeTestCase;


public class RfcHome extends BasicScreen{
	
	
	public RfcHome(WebDriver driver) {
		super(driver);
	}
	
	public RfcHome() {
		this(ChromeTestCase.getCurrentDriver());		
	}
	
	public RfcHome navigateToHome(){
		command.open("https://servicedesk.intranet/sc/index.do");
		return getNextPage(RfcHome.class);
	}
	
	public RfcLogin clickServiceCenterLink(){
		command.switchToFrame("detail");
		
		return getNextPage(RfcLogin.class);	
	}

}
